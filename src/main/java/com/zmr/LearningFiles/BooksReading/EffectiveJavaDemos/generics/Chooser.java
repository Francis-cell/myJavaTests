package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.generics;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author franciszmr
 * @Date 2023/12/18 22:26
 * @Version 1.0
 * @Description TODO
 **/
public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
