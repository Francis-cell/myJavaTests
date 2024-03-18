package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.ListNodeTests;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/12/25 14:02
 */
public class MyListTests {
    /** 初始化链表 */
    void createList() {
        // 无初始值的链表
        ArrayList<Integer> list1 = new ArrayList<>();

        // 有初始值的链表
        Integer[] nums = {1, 2, 3, 4, 5};
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(nums));
    }


    public static void main(String[] args) {
        //int[] ints = {1, 2, 3, 4, 5};
        //int[] ints1 = Arrays.copyOf(ints, ints.length * 2);
        //System.out.println("拷贝前ints的值为：" + Arrays.toString(ints));
        //System.out.println("拷贝后ints1的值为：" + Arrays.toString(ints1));

        int[] ints2 = {1, 2, 3, 4, 5};
        int[] ints3 = Arrays.copyOfRange(ints2, 1, ints2.length);
        System.out.println("拷贝前ints2的值为：" + Arrays.toString(ints2));
        System.out.println("拷贝前ints3的值为：" + Arrays.toString(ints3));
    }
}
