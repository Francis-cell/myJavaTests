package com.zmr.LearningFiles.MyGitHubProgramTests.Algorithms;

import java.util.List;
import java.util.TreeSet;

public class CombinationTests {
    public static void main(String[] args) {

//        // 回溯法 查看 1..n 数组中长度为 length 的所有数组
//        ArrayCombination arrayCombination = new ArrayCombination();
//        List<TreeSet<Integer>> ans = arrayCombination.combination(10, 5);
//
//        for (TreeSet<Integer> treeSet : ans) {
//            System.out.println(treeSet);
//        }

        // 回溯法（Combination.class 类中直接调用示例）
        Integer[] inputArr = new Integer[6];
        for (int i = 0; i <= 5; i++) {
            inputArr[i] = i;
        }
        Combination.combination(inputArr, 3);
    }
}
