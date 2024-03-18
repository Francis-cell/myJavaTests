package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.generics;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author franciszmr
 * @Date 2023/12/18 22:41
 * @Version 1.0
 * @Description TODO
 **/
public class ChooserGenerics<T> {
    private final T[] choiceArray;

    @SuppressWarnings("unchecked")
    public ChooserGenerics(Collection<T> choices){
        choiceArray = (T[]) choices.toArray();
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
