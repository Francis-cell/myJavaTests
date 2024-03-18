package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.searchDemos;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N = 0;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val) {
        // 查找键，找到则更新值，否则创建新的元素
        int i = rank(key);

        // 元素的位置已经存在，直接更新元素的值即可
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // 查看数组空间位置是否足够，如果不够进行扩容
        if (N == keys.length) {
            resize(2 * keys.length);
        }

        // 插入新元素，将数组 keys 和 vals 中的元素从 i 位置到 N 位置的元素统一向后移动一位
        for (int j = N; j < i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        // 将 i 位置的元素的 key 和 value 的值赋上
        keys[i] = key;
        vals[i] = val;
        // 这个 N 计数，主要是记录当前已经插入的元素的数量（用于和 keys.length 进行比较，从而获取到数组中剩余元素的数量）
        N++;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of keys in this symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        int low = 0, high = N-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }

    /**
     * 数组扩容
     * @param capacity
     */
    private void resize(int capacity) {
        assert capacity >= N;
        Key[] tmpKey = (Key[]) new Comparable[capacity];
        Value[] tmpValue = (Value[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            tmpKey[i] = keys[i];
            tmpValue[i] = vals[i];
        }

        keys = tmpKey;
        vals = tmpValue;
    }
}
