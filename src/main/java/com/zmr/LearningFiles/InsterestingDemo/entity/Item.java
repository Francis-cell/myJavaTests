package com.zmr.LearningFiles.InsterestingDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 物品（可放入到背包中的物品）
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    /** 物品 ID */
    private int itemId;

    /** 物品名称 */
    private String itemName;

    /** 可给玩家回复的血量 */
    private int addPlayerBlood;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", addPlayerBlood=" + addPlayerBlood +
                '}';
    }
}
