package com.zmr.LearningFiles.EffectiveJavaDemos.MethodsDemo;

import java.util.*;

public class CollectionMaxValue {
    /**
     * 使用异常返回的方法
     * @param c
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection.");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static <E extends Comparable<E>> Optional<E> maxOptional(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return Optional.of(result);
    }

    public static <E extends Comparable<E>> Optional<E> maxStream(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        Integer a = null;
        Set<Integer> sets = new HashSet<>();
        sets.add(a);
        // 这样用会直接抛出空指针异常（）
        // maxOptional(sets);
        maxOptional(sets).orElse(-1);
    }
}
