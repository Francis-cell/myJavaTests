package com.zmr.LearningFiles.JavaCoreTechnology.StreamDemo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class SteamDemo01 {
    public static void main(String[] args) {
        // 直接创建值
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        song.forEach(System.out::println);

        // 使用数组创建流
        Integer[] integers = new Integer[] {1, 2, 3, 4};
        Stream<Integer> stream = Arrays.stream(integers, 0, 3);
        stream.forEach(System.out::println);

        // 创建空流
        Stream<String> empty = Stream.empty();

        // 获取一个随机数的流(无限流)
        Stream<Double> randoms = Stream.generate(Math::random);
        // randoms.forEach(System.out::println);

        // 产生 0 1 2 3 ... 序列 (无限流)
        Stream<BigInteger> iterates = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        // iterates.forEach(System.out::println);

        // 产生 0 1 2 3 ... 序列 (有限流)
        BigInteger limit = new BigInteger("1000");
        Stream<BigInteger> iterates01 = Stream.iterate(BigInteger.ZERO,
                // n -> n.compareTo(limit) < 0,
                n -> n.add(BigInteger.ONE));
    }
}
