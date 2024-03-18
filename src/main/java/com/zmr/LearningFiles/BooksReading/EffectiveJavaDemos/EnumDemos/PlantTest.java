package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.EnumDemos;

import java.util.Arrays;
import java.util.EnumMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class PlantTest {
    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("Rose", Plant.LifeCycle.PERENNIAL),
                new Plant("Sunflower", Plant.LifeCycle.ANNUAL),
                new Plant("Daisy", Plant.LifeCycle.ANNUAL)
        };

        // demo01 运行结果
        // ANNUAL: [Sunflower, Daisy]
        // PERENNIAL: [Rose]
        // BIENNIAL: []
        Plant.demo01(garden);

        // demo02 运行结果
        // {ANNUAL=[Sunflower, Daisy], PERENNIAL=[Rose], BIENNIAL=[]}
        Plant.demo02(garden);

        // 运行结果: {PERENNIAL=[Rose], ANNUAL=[Sunflower, Daisy]}
        // with stream (not equals to demo02 method)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifecycle)));

        // 运行结果: {ANNUAL=[Sunflower, Daisy], PERENNIAL=[Rose]}
        // with stream (equals to demo02 method)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifecycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
