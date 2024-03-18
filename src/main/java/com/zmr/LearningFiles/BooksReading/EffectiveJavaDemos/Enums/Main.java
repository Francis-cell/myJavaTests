package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.Enums;

/**
 * @Author franciszmr
 * @Date 2023/12/21 22:09
 * @Version 1.0
 * @Description TODO
 **/
public class Main {
    public static void main(String[] args) {
        Ensemble solo = Ensemble.SOLO;
        Ensemble quartet = Ensemble.QUARTET;

        int numOfMusiciansInSolo = solo.numberOfMusicians();
        int numOfMusiciansInQuartet = quartet.numberOfMusicians();

        System.out.println("Number of musicians in solo: " + numOfMusiciansInSolo);
        System.out.println("Number of musicians in quartet: " + numOfMusiciansInQuartet);
    }
}
