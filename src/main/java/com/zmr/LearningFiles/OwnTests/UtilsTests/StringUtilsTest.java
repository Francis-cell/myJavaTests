package com.zmr.LearningFiles.OwnTests.UtilsTests;

import com.zmr.MyUtils.StringUtils.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        String[] arr = new String[] {"1", "2", "5"};
        Integer[] arr2 = new Integer[] {1,2,3};
        String s = StringUtils.joinStringForUpdateInSql(arr, ",");
        String s1 = StringUtils.joinStringForUpdateInSql(arr2, ",");
        System.out.println(s);
        System.out.println(s1);
    }
}
