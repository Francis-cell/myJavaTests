package com.zmr.LearningFiles.InsterestingDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 技能
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    /** 技能 ID */
    private int skillId;

    /** 技能名称 */
    private String skillName;

    /** 技能 CD */
    private int skillCDTime;

    /** 技能伤害 */
    private int skillHurt;

    public Skill(int skillId, String skillName, int skillHurt) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillHurt = skillHurt;
    }
}
