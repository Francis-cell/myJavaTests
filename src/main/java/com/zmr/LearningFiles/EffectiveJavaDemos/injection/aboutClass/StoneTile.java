package com.zmr.LearningFiles.EffectiveJavaDemos.injection.aboutClass;

import com.zmr.LearningFiles.EffectiveJavaDemos.injection.aboutInterface.Tile;

/**
 * @Author franciszmr
 * @Date 2023/12/5 21:41
 * @Version 1.0
 * @Description TODO
 **/
public class StoneTile implements Tile {
    @Override
    public void display() {
        System.out.println("StoneTile display!");
    }
}
