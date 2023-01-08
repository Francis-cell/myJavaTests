package MyLeetCodeTests.My2022Lists.D12_27.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName MyDequeTests
 * @Description 双向队列Java使用
 * @Author zhumengren
 * @Date 2022/12/27 17:50
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyDequeTests {
    public static void main(String[] args) {
        // 初始化双向队列
        Deque<Integer> deque = new LinkedList<>();
        // 元素入队
        // 添加到队尾
        deque.offerLast(2);
        deque.offerLast(5);
        deque.offerLast(4);
        // 添加到队首
        deque.offerFirst(3);
        deque.offerFirst(1);
        /** 1 3 2 5 4 */

        // 访问元素
        // 访问队首元素
        int peekFirst = deque.peekFirst();
        // 访问队尾元素
        int peekLast = deque.peekLast();

        // 元素出队
        // 队首元素
        int pollFirst = deque.pollFirst();
        // 队尾元素
        int pollLast = deque.pollLast();

        // 获取双向队列的长度
        int size = deque.size();

        // 判断双向队列是否为空
        boolean isEmpty = deque.isEmpty();

        System.out.println("队首元素:" + peekFirst);
        System.out.println("队尾元素:" + peekLast);
        System.out.println("队首元素--元素出队:" + pollFirst);
        System.out.println("队尾元素--元素出队:" + pollLast);
        System.out.println("双向队列长度:" + size);
        System.out.println("双向队列是否为空:" + isEmpty);
    }
}
