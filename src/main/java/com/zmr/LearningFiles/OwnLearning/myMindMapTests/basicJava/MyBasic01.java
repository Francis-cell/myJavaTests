package com.zmr.LearningFiles.OwnLearning.myMindMapTests.basicJava;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/26 11:35
 */
public class MyBasic01 {
    public static void main(String[] args) {
        //Integer integer = new Integer(1);
        //Integer integer1 = new Integer("1");


        //int i = 0;
        //Integer integer = new Integer(0);
        //Boolean b0 = i instanceof Integer;
        //Boolean b1 = i instanceof Object;
        //Boolean b2 = integer instanceof Integer;
        //Boolean b3 = integer instanceof Object;


        //int a = 10;
        //double b = 10.0;
        //long l = 10L;
        //// true
        //System.out.println(a==b);
        //// true
        //System.out.println(l==b);
        //
        //String s = "10";
        //System.out.println("10".equals(s));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        //arrayList.forEach(item->{
        //    System.out.println(item);
        //});


        //Object[] objects = arrayList.toArray();

        HashMap hashMap = new HashMap();
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        hashMap.put("1", "a");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


        //System.out.println(Arrays.asList(1, 2));


        //new LinkedList<>();
    }
}
