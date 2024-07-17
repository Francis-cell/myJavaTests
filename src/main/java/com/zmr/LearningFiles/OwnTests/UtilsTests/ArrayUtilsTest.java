package com.zmr.LearningFiles.OwnTests.UtilsTests;

import com.zmr.MyUtils.ArrayUtils.impl.ArrayUtilsImpl;
import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;

import java.util.List;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        String[] arr1 = new String[] { "1", "2" };
        String[] arr2 = new String[] { "1", "3" };
        List<String[]> ans = ArrayUtilsImpl.getInstance().getDifferentElementsFromTwoArray(arr1, arr2);
        PrintUtilsImpl.getInstance().printArr(ans.get(0));
        System.out.println("----------");
        PrintUtilsImpl.getInstance().printArr(ans.get(1));
    }
}
