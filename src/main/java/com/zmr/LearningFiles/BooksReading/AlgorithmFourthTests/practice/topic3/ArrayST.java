// package com.zmr.LearningFiles.BooksReading.AlgorithmFourthTests.practice.topic3;
//
// /**
//  * 使用无序数组实现基本的 API
//  */
// public class ArrayST<Key extends Comparable<Key>, Value> {
//     /** 默认声明的数组的大小 */
//     private int size;
//
//     public Key[] keys;
//     public Value[] values;
//
//     /** 创建有序符号表 */
//     public ArrayST(int capacity) {
//         keys = (Key[]) new Object[capacity];
//         values = (Value[]) new Object[capacity];
//     }
//
//
//     /**
//      * <p> 将键值对存入表中（若值为空则将键 key 从表中删除） </p>
//      * @param key
//      * @param val
//      */
//     void put(Key key, Value val) {
//         if (key == null) {
//             throw new IllegalArgumentException("first argument to put is null.");
//         }
//
//         if (val == null) {
//             delete(key);
//             return;
//         }
//
//         for (int i = 0; i < size; i++) {
//             if (keys[i].equals(key)) {
//                 values[i] = val;
//                 return;
//             }
//         }
//
//         if (size == keys.length) {
//             resize(keys.length * 2);
//         }
//
//         keys[size] = key;
//         values[size] = val;
//         size++;
//     }
//
//     /**
//      * <p> 获取键 key 对应的值（若 key 不存在则返回空） </p>
//      * @param key
//      * @return
//      */
//     Value get(Key key) {
//
//     }
//
//     /**
//      * <p> 从表中删除键 key （及其对应的值）</p>
//      * @param key
//      */
//     void delete(Key key) {
//         if (key == null) {
//             throw new IllegalArgumentException("the key argument to delete is null.");
//         }
//
//         for (int i = 0; i < size; i++) {
//             if (keys[i].equals(key)) {
//                 keys[i] = keys[size -1];
//                 values[i] = values[size - 1];
//
//                 keys[size - 1] = null;
//                 values[size - 1] = null;
//
//                 size--;
//                 break;
//             }
//         }
//     }
//
//     /**
//      * <p>键 key 是否存在于表中</p>
//      * @param key
//      * @return
//      */
//     boolean contains(Key key) {
//
//     }
//
//     /**
//      * <p>表是否为空</p>
//      * @return
//      */
//     boolean isEmpty() {
//         return size == 0;
//     }
//
//     /**
//      * <p>表中的键值对数量</p>
//      * @return
//      */
//     int size() {
//         return size;
//     }
//
//     /**
//      * <p>最小的键</p>
//      * @return
//      */
//     Key min() {
//
//     }
//
//     /**
//      * <p>最大的键</p>
//      * @return
//      */
//     Key max() {
//
//     }
//
//     /**
//      * <p>小于等于 key 的最大值</p>
//      * @param key
//      * @return
//      */
//     Key floor(Key key) {
//
//     }
//
//     /**
//      * <p>大于等于 key 的最小值</p>
//      * @param key
//      * @return
//      */
//     Key ceiling(Key key) {
//
//     }
//
//     /**
//      * <p>小于 key 的键的数量</p>
//      * @param key
//      * @return
//      */
//     int rank(Key key) {
//
//     }
//
//     /**
//      * <p>排名为 k 的键</p>
//      * @param k
//      * @return
//      */
//     Key select(int k) {
//
//     }
//
//     /**
//      * <p>删除最小的值</p>
//      */
//     void deleteMin() {
//
//     }
//
//     /**
//      * <p>删除最大的值</p>
//      */
//     void deleteMax() {
//
//     }
//
//     /**
//      * <p>[low .. high] 之间的键的数量</p>
//      * @param low
//      * @param high
//      * @return
//      */
//     int size(Key low, Key high) {
//
//     }
//
//     /**
//      * <p>[low .. high] 之间的所有键，已排序</p>
//      * @param low
//      * @param high
//      * @return
//      */
//     Iterable<Key> keys(Key low, Key high) {
//
//     }
//
//     /**
//      * <p>表中所有键的集合，已排序</p>
//      * @return
//      */
//     Iterable<Key> keys() {
//
//     }
//
//     /**
//      * 将当前的数组进行扩容
//      * @param capacity 要扩展到的容量信息
//      */
//     private void resize(int capacity) {
//         assert capacity >= N;
//         Object[][] newST = new Object[2][capacity];
//         // 初始化两个二维数组
//         Key[] keyArr = (Key[]) new Comparable[capacity];
//         Value[] valArr = (Value[]) new Comparable[capacity];
//         newST[0] = keyArr;
//         newST[1] = valArr;
//     }
// }
