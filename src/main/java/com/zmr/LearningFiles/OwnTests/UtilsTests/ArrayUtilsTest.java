package com.zmr.LearningFiles.OwnTests.UtilsTests;

import com.zmr.MyUtils.ArrayUtils.ArrayUtils;
import com.zmr.MyUtils.PrintUtils.PrintUtils;

import java.util.List;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        String[] arr1 = new String[] { "1", "2" };
        String[] arr2 = new String[] { "1", "3" };
        List<String[]> ans = ArrayUtils.getDifferentElementsFromTwoArray(arr1, arr2);
        PrintUtils.printArr(ans.get(0));
        System.out.println("----------");
        PrintUtils.printArr(ans.get(1));
    }
}
