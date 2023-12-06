package com.zmr.LearningFiles.EffectiveJavaDemos.injection.main;

import com.zmr.LearningFiles.EffectiveJavaDemos.injection.aboutClass.CeramicTile;
import com.zmr.LearningFiles.EffectiveJavaDemos.injection.aboutClass.Mosaic;
import com.zmr.LearningFiles.EffectiveJavaDemos.injection.aboutClass.StoneTile;
import com.zmr.LearningFiles.EffectiveJavaDemos.injection.aboutInterface.Tile;

/**
 * @Author franciszmr
 * @Date 2023/12/5 21:44
 * @Version 1.0
 * @Description TODO
 **/
public class Main {
    public static void main(String[] args) {
        Tile ceramicTile = Mosaic.create(CeramicTile::new);
        Tile stoneTile = Mosaic.create(StoneTile::new);

        ceramicTile.display();
        stoneTile.display();
    }
}
