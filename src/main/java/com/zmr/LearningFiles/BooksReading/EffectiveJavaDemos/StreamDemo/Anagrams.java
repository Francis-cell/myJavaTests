package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.StreamDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Anagrams {
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static void demo01(String args[]) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }

    public static void demo02(String args[]) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(word -> alphabetize(word), LinkedHashMap::new, toList()))
                    .values().stream()
                    // .forEach(group -> System.out.println(group.size() + ": " + group));
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(group -> System.out.println(group.size() + ": " + group));
        }
    }

    public static void main(String[] args) throws IOException {
        // 输出当前工作目录
        // 输出结果：Current Working Directory: D:\myOwnFiles\myJavaTests
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        String filePath = "./src/main/java/com/zmr/LearningFiles/EffectiveJavaDemos/StreamDemo/";
        String[] tmpArg = new String[] { filePath + "words.txt", "2" };
        // demo01(tmpArg);
        demo02(tmpArg);
    }
}
