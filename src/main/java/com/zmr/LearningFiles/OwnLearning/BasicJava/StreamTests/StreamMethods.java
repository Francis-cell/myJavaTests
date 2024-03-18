package com.zmr.LearningFiles.OwnLearning.BasicJava.StreamTests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamMethods
 * @Description Stream流常用的方法
 * @Author zhumengren
 * @Date 2022/10/13 18:17
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class StreamMethods {

    /** Stream流常用方法使用 */
    public static void streamUsuallyUsedMethods(ArrayList<String> lists) {
        System.out.println("==========forEach()===========");
        // 1、forEach()
        lists.stream().forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==========forEach()===========");


        System.out.println("==========filter()===========");
        // 2、filter()
        Stream<String> stringStream = lists.stream().filter((item) -> (item.length() > 1));
        stringStream.forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==========filter()===========");


        System.out.println("==========map()===========");
        // map()
        // map()是对集合中的对象进行映射的,将对象从一种类型转换成另一种类型
        // list.stream().map(num -> Integer.parseInt(num));
        Stream<String> stringStream1 = lists.stream().map((item) -> (item + "~"));
        stringStream1.forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==========map()===========");


        System.out.println("==========count()===========");
        // count()
        // count()对流数据进行统计
        // 运行结果：6
        System.out.println(lists.stream().count());
        System.out.println("==========count()===========");



        System.out.println("==========limit()===========");
        // limit()
        // limit() 选取流数据的前多少条数据
        lists.stream().limit(3).forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==========limit()===========");



        System.out.println("==========skip()===========");
        // skip()
        // 跳过流数据的前多少条数据，该方法与limit()方法刚好相反
        lists.stream().skip(2).forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==========skip()===========");



        System.out.println("==========concat()===========");
        // concat()
        // 实现对两个流数据进行合并
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("小黑");
        list1.add("小白");
        Stream.concat(lists.stream(), list1.stream()).forEach(item -> {
            System.out.println(item);
        });
        System.out.println("==========concat()===========");





    }

    /** 创建Stream对象 */
    public static void createStream() {
        // 一、Stream.of()方法--创建一个stream流对象的方式
        // 常用的Collection结构都有对应的Stream.of()方法

        // 1、Collection结构
        Collection<String> collection = new ArrayList();
        Stream<String> stream = collection.stream();

        // 2、List集合结构
        List list = new ArrayList<String>();
        Stream<String> stream1 = list.stream();

        // 3、ArrayList集合结构
        ArrayList arrayList = new ArrayList<String>();
        Stream<String> stream2 = arrayList.stream();

        // 4、LinkedList集合
        LinkedList linkedList = new LinkedList<>();
        Stream<String> stream3 = linkedList.stream();

        // 5、Stream.of()方式
        List list1 = new ArrayList<String>();
        Stream<List<String>> stream4 = Stream.of(list1);

        // 6、传入可变数组
        Stream<String> stream5 = Stream.of("1", "2", "3", "4", "5");
    }


    public static void main(String[] args) {
        // 初始化一个list列表
        ArrayList<String> lists = new ArrayList<>();
        lists.add("A");
        lists.add("B");
        lists.add("CA");
        lists.add("D");
        lists.add("EA");
        lists.add("F");

        // 创建Stream对象
        createStream();
        // 常用的Stream相关方法
        streamUsuallyUsedMethods(lists);
    }
}
