package com.zmr.LearningFiles.InsterestingDemo.main;

import com.zmr.LearningFiles.InsterestingDemo.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.zmr.LearningFiles.InsterestingDemo.coreAlgorithm.Greddy.GenerateResource.*;

/***
 * <p> 主体程序 </p>
 */
public class Main {
    /**
     * <p> 根据当前用户的技能列表，计算当前用户的伤害值（用于决定怪物随机生成的情况） </p>
     * <p> 方法：去掉一个最大值，去掉一个最小值，其余值求平均 </p>
     * @param skills 用户的技能列表信息
     * @param seed 随机种子
     * @return
     */
    private static int getPlayerHurt(Skill[] skills, int seed) {
        // 伤害数值
        int skillHurt = 0;

        // 获取到当前的技能列表的伤害数值信息
        int[] skillsHurtArr = new int[skills.length];
        for (int i = 0; i < skills.length; i++) {
            skillsHurtArr[i] = skills[i].getSkillHurt();
        }
        // 排序
        Arrays.sort(skillsHurtArr);
        int skillHurtSum = 0;
        int skillUsefulCount = 0;
        // 如果玩家的技能少于两个，则直接返回平均值即可
        if (skills.length <= 2) {
            for (int i = 0; i < skillsHurtArr.length; i++) {
                skillHurtSum += skillsHurtArr[i];
            }
            skillUsefulCount = skills.length;
        } else {
            // 如果玩家的技能超过2个
            for (int i = 1; i < skillsHurtArr.length - 1; i++) {
                skillHurtSum += skillsHurtArr[i];
            }
            skillUsefulCount = skills.length - 2;
        }

        skillHurt = (skillHurtSum % skillUsefulCount == 0) ?
                (skillHurtSum / skillUsefulCount) : (skillHurtSum / skillUsefulCount) + 1;
        return skillHurt;
    }

    /**
     * 初始化关卡
     * @param p 当前用户
     * @param playerHurt 获取当前玩家的伤害信息
     * @param monsters 当前关卡中的敌怪列表
     * @param items 当前关卡可获得的物品列表信息
     * @param itemNum 补给品数量
     * @param seed 随机种子
     */
    public static void levelInit(Player p, int playerHurt, Monster[] monsters, Item[] items,
                                 int itemNum, int seed) {
        // 经过“多重背包”生成本轮需要生成的怪物和补给品信息
        Object[] ans = greedyKnapsack(monsters, items, p, itemNum, playerHurt, seed);
        // 生成的怪物信息
        HashMap<String, Object> MonsterMap = (HashMap<String, Object>)ans[0];
        System.out.println("当前生成的怪物数量为：" + MonsterMap.get("monsterNum"));
        System.out.println("当前生成的怪物列表为：");
        printMap((HashMap<Monster, Integer>)MonsterMap.get("monsterMap"));
        // 生成的补给品信息
        HashMap<String, Object> ItemMap = (HashMap<String, Object>)ans[1];
        System.out.println("当前生成的补给品数量为：" + ItemMap.get("itemNum"));
        System.out.println("当前生成的补给品列表为：");
        printList((ArrayList<Item>)ItemMap.get("itemList"));
    }

    public static void main(String[] args) {
        // 随机种子
        int seed = (int)(Math.random() * 5) + 1;

        // 技能
        Skill[] skills = {
                new Skill(1, "普攻", 2),
                new Skill(2, "火球", 5),
                new Skill(3, "冰刺", 3),
                new Skill(4, "地刺", 2),
                new Skill(5, "毒气", 5),
                new Skill(6, "冰弹", 10)
        };

        // 玩家信息
        Player p = new Player(12, skills, 30, 2);
        // 获取当前玩家的伤害信息(去掉一个最大值，去掉一个最小值，其余值求平均)
        int playerHurt = getPlayerHurt(skills, seed);
        System.out.println("玩家伤害数值为：" + playerHurt);

        // 怪物列表
        Monster[] monsters = {
                new Monster(1, "史莱姆", 1, 2, 1, playerHurt),
                new Monster(2, "树桩怪", 3, 6, 3, playerHurt),
                new Monster(3, "火怪", 5, 3, 2, playerHurt),
                new Monster(4, "煤球怪", 3, 3, 1, playerHurt),
                new Monster(5, "蚯蚓怪", 2, 4, 2, playerHurt)
        };

        // 补给品列表
        Item[] items = {
                new Item(1, "口香糖", 3),
                new Item(2, "矿物水", 5),
                new Item(3, "面包", 10),
                new Item(4, "火腿", 30),
                new Item(5, "饼干", 6),
                new Item(6, "梅干菜扣肉", -3)
        };

        // 补给品数量
        int itemNum = (int)(Math.random() * (3 + 1));

        // 初始化
        levelInit(p, playerHurt, monsters, items, itemNum, seed);

    }
}
