package com.zmr.LearningFiles.EffectiveJavaDemos.StreamDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    /**
     * 获取 list 中前缀字符串的方法
     * @param list
     * @return
     * @param <E>
     */
    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    /**
     * 获取 list 中后缀字符串的方法
     * @param list
     * @return
     * @param <E>
     */
    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        // Stream<List<Integer>> prefixes = prefixes(ints);
        // // 将 Stream 转成 List
        // List<List<Integer>> res = prefixes.collect(Collectors.toList());
        // res.forEach(System.out::println);

        // 调用 SubLists 类的 of 方法，生成包含前缀和后缀的流
        Stream<List<Integer>> subListsStream = SubLists.of(ints);

        // 将流中的列表转换为字符串并打印输出
        subListsStream.map(Object::toString).forEach(System.out::println);
    }
}
