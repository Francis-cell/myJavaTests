
package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import com.zmr.MyUtils.PrintUtils.PrintUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest35 {
    public static void main(String[] args) {
        // //read()
        // try (BufferedReader br = new BufferedReader(new FileReader("/home/utarn/桌面/aaa.txt"))) {
        //     int c;
        //     //read()
        //     //读取单个字符并返回其整数表示，如果已到达流的末尾，则返回-1。
        //     while ((c = br.read())!=-1){
        //         System.out.print((char)c);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        //
        // //read(char[] cbuf, int off, int len)
        // try (BufferedReader br = new BufferedReader(new FileReader("/home/utarn/桌面/aaa.txt"))) {
        //     char[] buffer = new char[2];
        //     int numRead;
        //     //read(char[] cbuf, int off, int len)
        //     //将字符读入数组的一部分，返回读取的字符数，或者在流的末尾返回-1。
        //     if ((numRead = br.read(buffer, 0, buffer.length)) != -1) {
        //         System.out.print(new String(buffer, 0, numRead));
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // System.out.println();

        // //readLine()
        // try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\franc\\Desktop\\t\\a.txt"))) {
        //     String line;
        //     //readLine()
        //     //读取一个文本行，返回一个包含行内容的字符串，不包含任何行终止符。如果已到达流的末尾，则返回null。
        //     while ((line = br.readLine()) != null) {
        //         System.out.println(line);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // //ready()
        // //判断输入流是否准备好进行读取，返回布尔值。
        // try (BufferedReader br = new BufferedReader(new FileReader("/home/utarn/桌面/aaa.txt"))) {
        //     while (br.ready()) {
        //         System.out.println(br.readLine());
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // String s1 = new String("<123>");
        // String s2 = new String("ABC＞");
        // System.out.println(s1);
        // System.out.println(s2);

        ArrayList<Map<String, String>> vals = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("a", "1");
        map1.put("b", "1");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("a", "1");
        map2.put("b", "1");
        vals.add(map1);
        vals.add(map2);


        // vals.stream().collect(Collectors.toMap(item -> item.get("a"), item -> item.get("b")));

        // Map<String, String> result = vals.stream()
        //         .collect(Collectors.toMap(
        //                 item -> item.get("a"), // 键提取器
        //                 item -> item.get("b"), // 值提取器
        //                 (v1, v2) -> v1 // 如果有相同的键，则保留第一个值
        //         ));

        Map<String, String> result = vals
                .stream()
                .collect(Collectors.toMap(
                        item -> item.get("a"),
                        item -> item.get("b"),
                        (v1, v2) -> v1
                ));

        PrintUtils.printMap(result);
    }
}
