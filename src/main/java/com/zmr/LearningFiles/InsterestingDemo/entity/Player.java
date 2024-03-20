package com.zmr.LearningFiles.InsterestingDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 玩家
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    /** 玩家ID */
    private int playerId;

    /** 背包 */
    private BackPack backPack;

    /** 金钱 */
    private double money;

    /** 已经拥有的技能（伤害来源） */
    private Skill[] skills;

    /** 防御 */
    private int playerRecovery;

    /** 体力 */
    private int physicalStrength;

    /** 血量 */
    private int playerBlood;

    public Player(int playerId, Skill[] skills, int playerBlood, int playerRecovery) {
        this.playerId = playerId;
        this.skills = skills;
        this.playerBlood = playerBlood;
        this.playerRecovery = playerRecovery;
    }
}
