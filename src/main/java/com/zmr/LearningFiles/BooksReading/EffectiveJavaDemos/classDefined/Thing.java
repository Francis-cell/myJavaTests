package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.classDefined;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Thing {
    /** 物品名称 */
    private String name;

    /** 物品描述 */
    private String description;
}
