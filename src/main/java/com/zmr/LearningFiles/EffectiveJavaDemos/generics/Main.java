package com.zmr.LearningFiles.EffectiveJavaDemos.generics;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author franciszmr
 * @Date 2023/12/18 22:32
 * @Version 1.0
 * @Description TODO
 **/
public class Main {
    public static void main(String[] args) {
        Collection<String> objs = new ArrayList<>();
        objs.add("1");
        objs.add("2");
        objs.add("3");

        //Chooser chooser = new Chooser(objs);
        //Object choose = chooser.choose();
        //System.out.println(choose);


        ChooserGenerics<String> chooserGenerics = new ChooserGenerics<>(objs);
        String result = chooserGenerics.choose();
        System.out.println(result);
    }
}
