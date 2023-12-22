package com.zmr.LearningFiles.EffectiveJavaDemos.EnumDemos;

public class PhaseTest {
    public static void main(String[] args) {
        PhaseTurbo from = PhaseTurbo.LIQUID;
        PhaseTurbo to = PhaseTurbo.GAS;
        PhaseTurbo.Transition transition = PhaseTurbo.Transition.from(from, to);
        if (transition != null) {
            System.out.println("Transition from " + from + " to " + to + ": " + transition);
        } else {
            System.out.println("No transition found from " + from + " to " + to);
        }
    }
}
