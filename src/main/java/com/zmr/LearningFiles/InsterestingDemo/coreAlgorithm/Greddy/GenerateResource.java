package com.zmr.LearningFiles.InsterestingDemo.coreAlgorithm.Greddy;

import com.zmr.LearningFiles.InsterestingDemo.entity.Item;
import com.zmr.LearningFiles.InsterestingDemo.entity.Monster;
import com.zmr.LearningFiles.InsterestingDemo.entity.Player;
import com.zmr.LearningFiles.InsterestingDemo.entity.Skill;

import java.util.*;

/**
 * <p> 初始化对应层的资源 </p>
 * <p> 思考：使用多重背包-贪心算法，生成各种资源对玩家的影响 </p>
 */
public class GenerateResource {
    /**
     * <p> 多重背包主体算法实现（主要是为了生成当前层玩家会遇到的障碍以及资源补给） </p>
     * <p> 决定将会生成哪些怪物和物资的方法 </p>
     * @param monsters 要生成的怪物
     * @param items 要补给的资源
     * @param player 玩家
     * @param itemNum 补给品数量
     * @param seed 种子，用来影响生成的怪物数量和补给品数量，避免玩家始终不会被干掉
     * @return
     */
    public static Object[] greedyKnapsack(Monster[] monsters, Item[] items, Player player, int itemNum, int seed) {
        Object[] ans = new Object[2];
        // 生成的怪物信息映射
        HashMap<String, Object> monsterMap = new HashMap<>();
        // 生成的补给品信息映射
        HashMap<String, Object> itemMap = new HashMap<>();
        // 本轮生成的怪物组合信息
        List<Monster> generatedMonsters = new ArrayList<>();
        // 本轮生成的补给品组合信息
        List<Item> generatedItems = new ArrayList<>();


        // 根据当前玩家的伤害来计算 monsters 中的可承受伤害数量，进而将各种怪物进行排序
        Arrays.sort(monsters, Comparator.comparing(Monster::getPlayerGetHurtCount).reversed());
        // 资源的给予不能给太多，因此要使用正常贪心算法的反向，即不使用颠倒的数组，然后在这些资源中随机选择一部分
        // 根据物品可回复的血量进行排序
        Arrays.sort(items, Comparator.comparing(Item::getAddPlayerBlood));

        // 玩家剩余的血量信息
        int playerBlood = player.getPlayerBlood();
        // 已生成怪物数量
        int currentMonsterNum = 0;
        // 剩余可生成的补给品数量
        int currentItemNum = itemNum;


        // 一、随机怪物信息
        // 找到刚好杀不掉玩家的怪物组合（近似解）
        // 1、当怪物的数量为偶数的情况下：
        //    每种怪物最多生成占用当前层可生成最大怪物数的 50%(如果怪物数量 <= 2, 则忽略这个限制)
        // 当前层
        // 2、当怪物的数量为奇数的情况下：
        //    每种怪物最多可以占用当前层可生成最大怪物数的 50% + 1（将奇数消耗掉）
        for (int i = 0; i < monsters.length; i++) {
            // 首先找到刚好杀不掉玩家的当前怪物的最大数量
            int monsterHurt = monsters[i].getMonsterHurt();
            int tmpNum = playerBlood % monsterHurt == 0 ? (playerBlood / monsterHurt) - 1 : (playerBlood / monsterHurt);
            // 随机“当前怪物的数量”
            int currentMonsterCount = generateRandomInt(tmpNum, seed);
            // 更新“已生成怪物数量”
            currentMonsterNum += currentMonsterCount;
            // 玩家剩余的血量信息
            playerBlood -= currentMonsterCount * monsterHurt;
            // 将怪物放置到“本轮生成的怪物组合信息”中
            for (int j = 0; j < currentMonsterCount; j++) {
                generatedMonsters.add(monsters[i]);
            }
        }

        // 二、随机补给品信息
        for (int i = 0; i < items.length; i++) {
            // 随机当前的物品数量
            int tmpNum = generateRandomInt(currentItemNum, seed);
            // 如果随机数量 > 当前的物品数量，则说明会额外生成一些资源
            for (int j = 0; j < tmpNum; j++) {
                generatedItems.add(items[i]);
            }

            // 继续尝试生成其他的物品
            currentItemNum -= tmpNum;

            // 如果剩余的补给品数量已经 <= 0，则不再生成补给品
            if (currentItemNum <= 0) {
                break;
            }
        }

        // 本轮生成的怪物映射信息
        monsterMap.put("monsterNum", currentMonsterNum);
        monsterMap.put("monsterList", generatedMonsters);
        // 本轮生成的补给品映射信息
        itemMap.put("itemNum", itemNum-currentItemNum);
        itemMap.put("itemList", generatedItems);

        ans[0] = monsterMap;
        // 生成的补给物品信息列表
        ans[1] = itemMap;
        return ans;
    }

    /**
     * <p> 随机一个整数数值 </p>
     * <p> 防止每次生成的怪物或者物品总是达到最大值 </p>
     * @param maxValue 能随机的最大值
     * @param seed 种子
     * @return
     */
    private static int generateRandomInt(int maxValue, int seed) {
        // 随机一个的怪物或者物品的数量（在允许的最大值范围内）
        int ans = (int)(Math.random() * (maxValue + 1));
        // 通过种子随机增加或者减少，如果数量 < 0 则给定 0 值 (随机一个数量信息)
        int tmpRandom = (int)(Math.random() * (seed + 1));
        int randomAddOrSubtract = Math.max(tmpRandom, 0);
        // 判断是增加生成还是减少生成
        double randomVal = Math.random();
        if (randomVal <= 0.618) {
            // 减少生成的数量
            ans = Math.max((ans - randomAddOrSubtract), 0);
        } else {
            // 增加生成的数量
            ans = ans + randomAddOrSubtract;
        }
        return ans;
    }

    /**
     * <p> 打印列表中的元素 </p>
     * @param lists
     * @param <E>
     */
    private static <E> void printList(List<E> lists) {
        // 用于记录当前怪物或者补给品的名称以及对应的数量信息
        HashMap<String, Integer> map = new HashMap<>();
        String tmpName = "";
        for (E e : lists) {
            // 打印怪物信息
            if (e instanceof Monster) {
                tmpName = ((Monster) e).getMonsterName();
            } else if (e instanceof Item) {
                tmpName = ((Item) e).getItemName();
            }

            if (map.containsKey(tmpName)) {
                map.put(tmpName, map.get(tmpName) + 1);
            } else {
                map.put(tmpName, 1);
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        // 技能
        Skill[] skills = {
              new Skill(1, "普攻", 2),
              new Skill(2, "火球", 5),
              new Skill(3, "冰刺", 3)
        };
        // 玩家信息
        Player p = new Player(12, skills, 30);
        // 怪物列表
        Monster[] monsters = {
                new Monster(1, "史莱姆", 1, 5, p.getSkills()[0].getSkillHurt()),
                new Monster(2, "树桩怪", 3, 10, p.getSkills()[0].getSkillHurt()),
                new Monster(3, "火怪", 5, 3, p.getSkills()[0].getSkillHurt())
        };
        // 补给品列表
        Item[] items = {
                new Item(1, "口香糖", 3),
                new Item(2, "矿物水", 5),
                new Item(3, "面包", 10)
        };
        // 补给品数量
        int itemNum = (int)(Math.random() * (6 + 1));
        // 随机种子
        int seed = (int)(Math.random() * (itemNum + 1));
        // 经过“多重背包”生成本轮需要生成的怪物和补给品信息
        Object[] ans = greedyKnapsack(monsters, items, p, itemNum, seed);
        // 生成的怪物信息
        HashMap<String, Object> MonsterMap = (HashMap<String, Object>)ans[0];
        System.out.println("当前生成的怪物数量为：" + MonsterMap.get("monsterNum"));
        System.out.println("当前生成的怪物列表为：");
        printList((ArrayList<Monster>)MonsterMap.get("monsterList"));
        // 生成的补给品信息
        HashMap<String, Object> ItemMap = (HashMap<String, Object>)ans[1];
        System.out.println("当前生成的补给品数量为：" + ItemMap.get("itemNum"));
        System.out.println("当前生成的补给品列表为：");
        printList((ArrayList<Item>)ItemMap.get("itemList"));
    }
}
