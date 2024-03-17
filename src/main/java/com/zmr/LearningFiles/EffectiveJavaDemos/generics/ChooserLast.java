package com.zmr.LearningFiles.EffectiveJavaDemos.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author franciszmr
 * @Date 2023/12/18 22:47
 * @Version 1.0
 * @Description TODO
 **/
public class ChooserLast<T> {
    private final List<T> choiceList;

    public ChooserLast(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
