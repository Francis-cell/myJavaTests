package com.zmr.LearningFiles.InsterestingDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

/**
 * 背包
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BackPack {
    /** 背包 ID */
    private int backPackId;

    /** 背包总容量 */
    private int totalCapacity;

    /** 当前背包剩余容量 */
    private int remainingCapacity;

    /** 物品列表 */
    private Item item;
}
