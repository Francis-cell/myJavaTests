package com.zmr.LearningFiles.OwnTests.MyJavaTests.StreamAbout;

import com.zmr.MyUtils.ArrayUtils.impl.ArrayUtilsImpl;
import com.zmr.MyUtils.PrintUtils.impl.PrintUtilsImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo01 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        String[] arr = new String[] {"1", "2", "3"};

        List<String> ans = new ArrayList<>();

        ans = myList.stream().filter(item -> {
            if (ArrayUtilsImpl.getInstance().arrContainsElement(arr, item)) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());

        // myList.stream().filter(item -> {
        //     if ((new ArrayUtilsImpl()).arrContainsElement(arr, item)) {
        //         ans.add(item);
        //         System.out.println(1);
        //         return true;
        //     } else {
        //         return false;
        //     }
        // });

        // myList.stream().forEach(item -> {
        //     if ((new ArrayUtilsImpl()).arrContainsElement(arr, item)) {
        //         ans.add(item);
        //         System.out.println(1);
        //     }
        // });

        // PrintUtilsImpl.getInstance().printList(ans);
    }
}
