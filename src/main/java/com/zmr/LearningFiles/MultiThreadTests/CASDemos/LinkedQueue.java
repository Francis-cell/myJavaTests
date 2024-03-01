package com.zmr.LearningFiles.MultiThreadTests.CASDemos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p> 设计说明： </p>
 * <p> 链接队列比栈更为复杂，因为它必须支持对头节点和尾节点的快速访问；因此，它需要单独维护头指针和尾指针；其中有两个指针指向
 * 位于尾部的节点：当前最后一个元素的 next 指针，以及尾节点。当成功插入一个新元素时，这两个指针都需要采用原子操作来更新。</p>
 * <p> 初看起来，这个操作无法通过原子变量来实现。在更新这两个指针时需要不同的 CAS 操作，并且如果第一个 CAS 成功，但第二个
 * CAS 失败，那么队列将处于不一致的状态。而且，即使这两个 CAS 都成功了，那么在执行这两个 CAS 之间，仍可能有另外一个线程
 * 会访问这个队列。</p>
 * <p> 因此，在为链接队列构建非阻塞算法时，需要考虑到这两种情况。 </p>
 * <p>  </p>
 * <p>  </p>
 * <p> 我们需要使用一些技巧： </p>
 * <p> 第一个技巧: </p>
 * <p> 即使在一个包含多个步骤的更新操作中，也要确保数据结构总是处于一致的状态； </p>
 * <p> 这样，当线程 B 到达时，如果发现线程 A 正在执行更新，那么线程 B 就知道有一个操作已部分完成，并且不能立即开始自己的
 * 更新操作。然后 B 可以等待（通过反复检查队列的状态）并直到 A 更新完成，从而使得两个线程不会互相干扰；</p>
 * <p> 虽然这种方法能够使不同的线程“轮流”访问数据结构，并且不会造成破坏，但如果一个线程在更新操作中失败了，那么其他的线程
 * 都无法再访问队列。 </p>
 * <p>  </p>
 * <p>  </p>
 * <p> 要使得该算法成为一个非阻塞算法，必须确保当一个线程失败时不会妨碍其他线程继续执行下去。 </p>
 * <p> 第二个技巧是： </p>
 * <p> 如果当 B到达时发现 A 正在修改数据结构，那么在数据结构中应该有足够多的信息，使得 B 能完成 A 的更新操作。 </p>
 * <p> 如果 B“帮助”A 完成了更新操作，那么 B 可以执行自己的操作，而不用等待 A 的操作完成。当 A 恢复后再试图完成其操作时，
 * 会发现 B 已经替它完成了。 </p>
 * @param <E>
 */
@ThreadSafe
public class LinkedQueue<E> {
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    // 初始化一个为空的节点
    private final Node<E> dummy = new Node<E> (null, null);

    // 初始化头节点
    private final AtomicReference<Node<E>> head
            = new AtomicReference<>(dummy);

    // 初始化尾节点
    private final AtomicReference<Node<E>> tail
            = new AtomicReference<>(dummy);

    /**
     * <p> 步骤A、B、C、D 的补充说明 </p>
     * <p> </p>
     * <p> LinkedQueue.put 方法在插入新元素之前，将首先检查队列是否处于中间状态(步骤 A)
     * 如果是，那么有另一个线程正在插入元素(在步骤 C和 D之间)。此时当前线程不会等待其他
     * 线程执行完成，而是帮助它完成操作，并将尾节点向前推进一个节点(步骤 B)。然后，它将重
     * 复执行这种检查，以免另一个线程已经开始插入新元素，并继续推进尾节点，直到它发现队列
     * 处于稳定状态之后，才会开始执行自己的插入操作。 </p>
     * <p> </p>
     * <p> 由于步骤 C中的 CAS 将把新节点链接到队列尾部，因此如果两个线程同时插入元素，那
     * 么这个 CAS 将失败。在这样的情况下，并不会造成破坏:不会发生任何变化，并且当前的线程
     * 只需重新读取尾节点并再次重试。如果步骤 C 成功了，那么插入操作将生效，第二个 CAS(步
     * 骤 D)被认为是一个“清理操作”，因为它既可以由执行插入操作的线程来执行，也可以由其他
     * 任何线程来执行。如果步骤 D 失败，那么执行插入操作的线程将返回，而不是重新执行 CAS
     * 因为不再需要重试一另一个线程已经在步骤 B 中完成了这个工作。这种方式能够工作，因
     * 为在任何线程尝试将一个新节点插入到队列之前，都会首先通过检查 tailNext 是否非空来判
     * 断是否需要清理队列。如果是，它首先会推进尾节点(可能需要执行多次)，直到队列处于稳
     * 定状态。 </p>
     * @param item
     * @return
     */
    public boolean put(E item) {
        Node<E> newNode = new Node<E> (item, null);
        while (true) {
            // 获取当前尾指针所在的位置
            Node<E> curTail = tail.get();
            // 获取当前尾指针指向节点的下一个节点
            Node<E> tailNext = curTail.next.get();

            // 检查是否有正在更新的尾节点，且已经更新完成的情况
            if (curTail == tail.get()) {
                if (tailNext != null) {                                            // A
                    // 队列处于中间状态，推进尾节点
                    // TODO-假设当前的线程是 B，而 A 正在执行插入尾节点的操作，但是 A 还没有完成（包括 A 插入失败了；或者 A 还未完成插入）
                    // TODO-这种情况下线程 B 帮助线程 A 将没有插入进去的节点插入完成；
                    tail.compareAndSet(curTail, tailNext);                         // B
                } else {
                    // 处于稳定状态，尝试插入新节点
                    if (curTail.next.compareAndSet(null, newNode)) {        // C
                        // 插入操作成功，尝试推进尾节点
                        tail.compareAndSet(curTail, newNode);                      // D
                        return true;
                    }
                }
            }
        }
    }
}
