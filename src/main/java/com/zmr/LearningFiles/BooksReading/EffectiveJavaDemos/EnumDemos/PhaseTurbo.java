package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.EnumDemos;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum PhaseTurbo {
    SOLID, LIQUID, GAS;

    public enum Transition {
        // 融化
        MELT(SOLID, LIQUID),
        // 冻结
        FREEZE(LIQUID, SOLID),
        // 煮
        BOIL(LIQUID, GAS),
        // 凝结
        CONDENSE(GAS, LIQUID),
        // 升华
        SUBLIME(SOLID, GAS),
        // 沉淀、降落（液态 or 气态 --> 固态）
        DEPOSIT(GAS, SOLID);

        private final PhaseTurbo from;
        private final PhaseTurbo to;

        Transition(PhaseTurbo from, PhaseTurbo to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map
        private static final Map<PhaseTurbo, Map<PhaseTurbo, Transition>>
                m = Stream.of(values()).collect(groupingBy(t -> t.from,
                () -> new EnumMap<>(PhaseTurbo.class),
                toMap(t -> t.to, t -> t,
                        (x, y) -> y, () -> new EnumMap<>(PhaseTurbo.class))));

        public static Transition from(PhaseTurbo from, PhaseTurbo to) {
            System.out.println(m);
            return m.get(from).get(to);
        }
    }
}
