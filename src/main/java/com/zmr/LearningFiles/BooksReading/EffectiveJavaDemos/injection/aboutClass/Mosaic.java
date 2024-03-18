package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.injection.aboutClass;

import com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.injection.aboutInterface.Tile;

import java.util.function.Supplier;

/**
 * @Author franciszmr
 * @Date 2023/12/5 21:42
 * @Version 1.0
 * @Description TODO
 **/
public class Mosaic {
    public static <T extends Tile> Tile create(Supplier<? extends Tile> tileFactory) {
        return tileFactory.get();
    }
}
