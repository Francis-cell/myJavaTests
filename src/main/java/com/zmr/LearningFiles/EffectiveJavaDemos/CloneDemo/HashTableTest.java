package com.zmr.LearningFiles.EffectiveJavaDemos.CloneDemo;

public class HashTableTest implements Cloneable {
    private static final int DEAFULT_INITIAL_CAPACITY = 16;

    private Entry[] buckets = new Entry[DEAFULT_INITIAL_CAPACITY];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 添加一个支持正确克隆方式的方法
        Entry deepCopy() {
            // // 递归调用的方式实现 deepCopy
            // return new Entry(key, value,
            //         next == null ? null : next.deepCopy());

            // 迭代方式实现 deepCopy
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    // /**
    //  * 存在问题的克隆方法
    //  * @return
    //  */
    // @Override
    // public HashTableTest clone() {
    //     try {
    //         HashTableTest result = (HashTableTest) super.clone();
    //         // 使用这种克隆方式进行克隆，将会是存在问题的，数组引用的链表与原始对象是一样的，从而引起克隆对象和原始对象之间的不确定行为
    //         result.buckets = buckets.clone();
    //         return result;
    //     } catch (CloneNotSupportedException e) {
    //         throw new AssertionError();
    //     }
    // }


    /**
     * 正确的 copy 方法（虽然这种方式很灵活，如果散列桶不是很长，也会工作的很好，但是这样克隆一个链表并不是一种好方法，因为针对列表中的每一个
     * 元素，它都要消耗一段栈空间。如果链表比较长，这很容易导致栈溢出。为了避免这种情况，调整 deepCopy 中的递归方法为迭代方法）
     * @return
     */
    @Override
    public HashTableTest clone() {
        try {
            HashTableTest result = (HashTableTest) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
