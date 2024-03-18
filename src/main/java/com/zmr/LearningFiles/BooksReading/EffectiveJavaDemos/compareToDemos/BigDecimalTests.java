package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.compareToDemos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

/***
 * BigDecimal 中的 CompareTo 方法和 equals 方法的返回值是不一样的
 */
public class BigDecimalTests {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("1.00");
        // 如果是 HashSet 示例（使用 equals 进行的比较操作）
        HashSet<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(b1);
        hashSet.add(b2);
        // [1.0, 1.00]
        System.out.println(hashSet);

        // 如果是 TreeSet 示例（使用 compareTo 进行的比较操作）
        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(b1);
        treeSet.add(b2);
        // [1.0]
        System.out.println(treeSet);
    }
}
