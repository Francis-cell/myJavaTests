package com.zmr.LearningFiles.OwnLearning.BasicJava.StreamTests;

import java.util.ArrayList;

/**
 * @ClassName StreamTest01
 * @Description 流测试01
 * @Author zhumengren
 * @Date 2022/10/13 18:03

 * @Version 1.0
 **/
public class StreamTest01 {

    /** 传统方式写法 */
    public static void traditionalWay() {
        // 声明一个ArrayList
        ArrayList<String> lists = new ArrayList<>();
        lists.add("A");
        lists.add("B");
        lists.add("CA");
        lists.add("D");
        lists.add("EA");
        lists.add("F");

        // 挑选list中包含A的
        ArrayList<String> lists1 = new ArrayList<>();
        for (String s : lists) {
            if (s.indexOf("A") >= 0) {
                lists1.add(s);
            }
        }

        // 挑选长度为2的结果
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : lists1) {
            if (s.length() == 2) {
                list2.add(s);
            }
        }

        // 打印最终结果
        for (String s : list2) {
            System.out.println(s);
        }
    }


    /** Stream实现方式 */
    public static void streamWay() {
        // 声明一个ArrayList
        ArrayList<String> lists = new ArrayList<>();
        lists.add("A");
        lists.add("B");
        lists.add("CA");
        lists.add("D");
        lists.add("EA");
        lists.add("F");

        lists.stream()
                .filter((item) -> (item.indexOf("A") >= 0))
                .filter((item) -> (item.length() == 2))
                .forEach((item) -> System.out.println(item));
    }


    public static void main(String[] args) {
        // 1、传统方式调用
        traditionalWay();

        // 2、Stream流的实现方式
        streamWay();
    }
}
