package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.EnumDemos;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

class Plant {
    enum LifeCycle {
        // 一年期
        ANNUAL,
        // 多年期
        PERENNIAL,
        // 两年期
        BIENNIAL
    }

    final String name;
    final LifeCycle lifecycle;

    Plant(String name, LifeCycle lifecycle) {
        this.name = name;
        this.lifecycle = lifecycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void demo01(Plant[] garden) {
        // 创建指定数量的集合进行数据的存储
        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for (Plant p : garden) {
            // TODO -- 注意，这里使用序数的方式实现将一种新的植物放置到 set 中
            plantsByLifeCycle[p.lifecycle.ordinal()].add(p);
        }

        // print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    public static void demo02(Plant[] garden) {
        EnumMap<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifecycle).add(p);
        }

        System.out.println(plantsByLifeCycle);
    }
}
