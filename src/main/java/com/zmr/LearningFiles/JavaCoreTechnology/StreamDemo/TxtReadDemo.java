package com.zmr.LearningFiles.JavaCoreTechnology.StreamDemo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TxtReadDemo {
    public final static String CORE_DEMO_PATH;

    static {
        CORE_DEMO_PATH = "D:\\myOwnFiles\\myJavaTests\\src\\main\\java\\com\\zmr\\LearningFiles\\JavaCoreTechnology";
    }

    public static List<String> txtReadFun(String txtPath) throws IOException {
        // // 获取当前位置的绝对路径信息
        // Path currentWorkingDir = Paths.get(".").toAbsolutePath();
        // System.out.println("Current working directory: " + currentWorkingDir);

        // 读取指定路径下的 txt 文件信息，并将文本转换成 String
        String contents = new String(Files.readAllBytes(
                Paths.get(txtPath)
        ), StandardCharsets.UTF_8);

        String[] wordsArray = contents.split("\\PL+");
        List<String> words = Arrays.stream(wordsArray).collect(Collectors.toList());
        return words;
    }

    /** 方法1：使用普通的 for 循环进行处理 */
    public static void iteratorDemo01(List<String> words) {
        // 开启迭代
        int count = 0;
        for (String w : words) {
            if (w.length() > 12) {
                count++;
            }
        }
        System.out.println(count);
    }

    /** 方法2：使用流操作处理 */
    public static void iteratorDemo02(List<String> words) {
        // 非并行处理
        long start = System.currentTimeMillis();
        // 开启迭代
        long count = words.stream()
                .filter(w -> w.length() > 12)
                .count();
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println("非并行操作情况下迭代查找时间长度为 " + (end - start) + " 毫秒");

        // 并行处理
        long start2 = System.currentTimeMillis();
        // 开启迭代
        long count2 = words.parallelStream()
                .filter(w -> w.length() > 12)
                .count();
        System.out.println(count2);
        long end2 = System.currentTimeMillis();
        System.out.println("并行操作情况下迭代查找时间长度为 " + (end2 - start2) + " 毫秒");
    }

    public static void main(String[] args) throws IOException {
        String txtPath = CORE_DEMO_PATH + "\\StreamDemo\\txts\\demo01.txt";
        List<String> res = txtReadFun(txtPath);
        // 传统迭代实现
        iteratorDemo01(res);
        // 流处理
        iteratorDemo02(res);
    }
}
