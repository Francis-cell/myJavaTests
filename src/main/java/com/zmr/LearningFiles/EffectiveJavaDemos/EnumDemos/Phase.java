package com.zmr.LearningFiles.EffectiveJavaDemos.EnumDemos;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        // 融化
        MELT,
        // 冻结
        FREEZE,
        // 煮
        BOIL,
        // 凝结
        CONDENSE,
        // 升华
        SUBLIME,
        // 沉淀、降落（液态 or 气态 --> 固态）
        DEPOSIT;
    }

    // Rows indexed by from-ordinal, cols by to-ordinal
    private static final Transition[][] TRANSITIONS = {
            // 固态水到其他状态转换列表
            { null, Transition.MELT, Transition.SUBLIME },
            // 液态水到其他状态转换
            { Transition.FREEZE, null, Transition.BOIL },
            // 气态水向其他状态转换
            { Transition.DEPOSIT, Transition.CONDENSE, null }
    };

    // Returns the phase transition from one phase to another
    public static Transition from(Phase from, Phase to) {
        return TRANSITIONS[from.ordinal()][to.ordinal()];
    }
}
