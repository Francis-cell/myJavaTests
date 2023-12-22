package com.zmr.LearningFiles.EffectiveJavaDemos.GenericsDemos;

import java.util.concurrent.ThreadLocalRandom;

public class GenericsMultiParams {
    // Unsafe - Exposes a reference to its genetic parameter array!
    static  <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        // Can't get here
        throw new AssertionError();
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
    }
}
