package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.MethodsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            // list.remove(i);
            list.remove((Integer) i);
        }
        // 对于 set, 删除的是的值和 i 相等的元素
        // [-3, -2, -1, 0, 1, 2] -- 原始 set
        // [-3, -2, -1, 1, 2] -- -- 移除为 0 的元素
        // [-3, -2, -1, 2] -- -- 移除为 1 的元素
        // [-3, -2, -1] -- -- 移除为 2 的元素


        // 对于 list, 删除的是指定下标的元素，list 中元素变化如下
        // [-3, -2, -1, 0, 1, 2] -- 原始 list
        // [-2, -1, 0, 1, 2] -- 移除下标为 0 的元素
        // [-2, 0, 1, 2] -- 移除下标为 1 的元素
        // [-2, 0, 2] -- 移除下标为 2 的元素

        System.out.println(set + " " + list);
    }
}
