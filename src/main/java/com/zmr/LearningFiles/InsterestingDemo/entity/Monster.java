package com.zmr.LearningFiles.InsterestingDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 怪物
 */
@Getter
@Setter
@NoArgsConstructor
public class Monster {
    /** ID */
    private int monsterId;

    /** 名称 */
    private String monsterName;

    /** 伤害 */
    private int monsterHurt;

    /** 防御 */
    private int monsterRecovery;

    /** 血量 */
    private int monsterBlood;

    /** 玩家被攻击将会受到的伤害数值(背包-贪心算法依据) */
    private int playerGetHurtCount = 0;

    public Monster(int monsterId, String monsterName, int monsterHurt, int monsterBlood) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.monsterHurt = monsterHurt;
        this.monsterBlood = monsterBlood;
    }

    public Monster(int monsterId, String monsterName, int monsterHurt, int monsterBlood, int playerHurt) {
        // 当前怪物可承受当前玩家伤害的次数
        int playerGetHurtCount = monsterBlood % playerHurt == 0 ?
                monsterBlood / playerHurt : monsterBlood / playerHurt + 1;
        // 当前怪物可以给予玩家的伤害总数（暂定玩家主动出击-怪物不会先攻击）
        this.playerGetHurtCount = playerGetHurtCount * monsterHurt;

        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.monsterHurt = monsterHurt;
        this.monsterBlood = monsterBlood;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", monsterName='" + monsterName + '\'' +
                ", monsterHurt=" + monsterHurt +
                ", monsterRecovery=" + monsterRecovery +
                ", monsterBlood=" + monsterBlood +
                ", playerGetHurtCount=" + playerGetHurtCount +
                '}';
    }
}
