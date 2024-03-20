package com.zmr.LearningFiles.InsterestingDemo.coreAlgorithm.Greddy;

import com.zmr.LearningFiles.InsterestingDemo.entity.Item;
import com.zmr.LearningFiles.InsterestingDemo.entity.Monster;
import com.zmr.LearningFiles.InsterestingDemo.entity.Player;

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
     * @param playerHurt 玩家可打出的伤害值
     * @param seed 种子，用来影响生成的怪物数量和补给品数量，避免玩家始终不会被干掉
     * @return
     */
    public static Object[] greedyKnapsack(Monster[] monsters, Item[] items, Player player, int itemNum,
                                          int playerHurt, int seed) {
        Object[] ans = new Object[2];
        // 生成的怪物信息映射
        HashMap<String, Object> monsterMap;
        // 生成的补给品信息映射
        HashMap<String, Object> itemMap;

        // 根据当前玩家的伤害来计算 monsters 中的可承受伤害数量，进而将各种怪物进行排序
        Arrays.sort(monsters, Comparator.comparing(Monster::getPlayerGetHurtCount).reversed());
        // 资源的给予不能给太多，因此要使用正常贪心算法的反向，即不使用颠倒的数组，然后在这些资源中随机选择一部分
        // 根据物品可回复的血量进行排序
        Arrays.sort(items, Comparator.comparing(Item::getAddPlayerBlood));

        // 随机怪物
        monsterMap = generateRandomMonsters(monsters, player, playerHurt, seed);
        // 随机补给品
        itemMap = generateRandomItems(items, itemNum, seed);

        ans[0] = monsterMap;
        // 生成的补给物品信息列表
        ans[1] = itemMap;

        return ans;
    }

    /**
     * 随机怪物
     * @param monsters 可选怪物列表
     * @param player 玩家
     * @param playerHurt 玩家伤害[外部可选的]
     * @param seed 随机种子
     * @return
     */
    private static HashMap<String, Object> generateRandomMonsters(Monster[] monsters, Player player, int playerHurt,
                                                                 int seed) {
        // 生成的怪物信息映射
        HashMap<String, Object> monsterMap = new HashMap<>();
        // 本轮生成的怪物组合信息
        HashMap<String, Integer> generatedMonstersMap = new HashMap<>();


        // 玩家剩余的血量信息
        int playerBlood = player.getPlayerBlood();
        // 当前玩家的防御值信息
        int playerRecovery = player.getPlayerRecovery();
        // 已生成怪物数量
        int currentMonsterNum = 0;

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
            // 设计01：所有的敌人只会攻击一次的情况下（显然不太可能）
            // int tmpNum = playerBlood % monsterHurt == 0 ? (playerBlood / monsterHurt) - 1 : (playerBlood / monsterHurt);
            // 设计02：需要怪物被玩家打击的次数，即玩家会受到玩家攻击次数 - 1 次伤害
            // int playerHurtNum = (monsters[i].getMonsterBlood() % playerHurt == 0) ?
            //         (monsters[i].getMonsterBlood() / playerHurt) - 1 : (monsters[i].getMonsterBlood() / playerHurt);
            // int tmpNum = (playerBlood % (monsterHurt * playerHurtNum)  == 0) ?
            //         (playerBlood / (monsterHurt * playerHurtNum)) - 1 : (playerBlood / (monsterHurt * playerHurtNum));
            // 设计03：怪物+护盾的防御值信息、玩家引入护甲值设定
            // 当前怪物的血量
            int monsterBlood = monsters[i].getMonsterBlood();
            // 当前怪物的防御值
            int monsterRecovery = monsters[i].getMonsterRecovery();
            // 玩家 --> 当前怪物 (伤害值)
            int playerToMonsterHurt = (playerHurt - monsterRecovery) <= 0 ? 0 : (playerHurt - monsterRecovery);
            // 当前怪物 --> 玩家 (伤害值)
            int monsterToPlayerHurt = (monsterHurt - playerRecovery) <= 0 ? 0 : (monsterHurt - playerRecovery);
            // 不要生成当前玩家根本打不动的怪
            if (playerToMonsterHurt == 0) {
                continue;
            }
            int playerHurtNum = (monsterBlood % playerToMonsterHurt == 0) ?
                    (monsterBlood / playerToMonsterHurt) - 1 :
                    (monsterBlood / playerToMonsterHurt);
            // 如果怪物对玩家伤害为0，或者怪物会被玩家一击毙命，则怪物的数量直接使用种子随机生成即可
            int tmpNum = (monsterToPlayerHurt == 0 || (playerToMonsterHurt >= monsterBlood)) ?
                    generateRandomInt(seed, seed) :
                    (playerBlood % (monsterToPlayerHurt * playerHurtNum)  == 0) ?
                            (playerBlood / (monsterToPlayerHurt * playerHurtNum)) - 1 :
                            (playerBlood / (monsterToPlayerHurt * playerHurtNum));
            // 随机“当前怪物的数量”
            int currentMonsterCount = generateRandomInt(tmpNum, seed);
            // // 更新“已生成怪物数量”
            // currentMonsterNum += currentMonsterCount;
            // 玩家剩余的血量信息
            playerBlood -= currentMonsterCount * monsterToPlayerHurt;
            // 将怪物放置到“本轮生成的怪物组合信息”中
            if (currentMonsterCount != 0) {
                generatedMonstersMap.put(monsters[i].getMonsterName(), currentMonsterCount);
            }
        }

        // 遍历已生成的各种怪物的数量，然后再做一次随机，随机范围在已生成数值的 25% - 75% 之间，如果不足1，则设置为1
        for (Map.Entry<String, Integer> entry : generatedMonstersMap.entrySet()) {
            String monster = entry.getKey();
            Integer count = entry.getValue();

            // 数量再进行一次随机 (随机范围在已生成数值的 25% - 75% 之间，如果不足1，则设置为1)
            int tmpRandomNum = count;
            int minNum = (int)(0.25 * tmpRandomNum);
            int maxNum = (int)(0.75 * tmpRandomNum);
            tmpRandomNum = (int)(minNum + (maxNum - minNum) * Math.random());
            // 更新后为0的数据，最低保证为1
            if (tmpRandomNum == 0) {
                tmpRandomNum = 1;
            }
            // 使用新的值
            generatedMonstersMap.put(monster, tmpRandomNum);
            // 更新
            currentMonsterNum += tmpRandomNum;
        }

        // 本轮生成的怪物映射信息
        monsterMap.put("monsterNum", currentMonsterNum);
        monsterMap.put("monsterMap", generatedMonstersMap);

        return monsterMap;
    }

    /**
     * 随机补给品
     * @param items
     * @param itemNum
     * @param seed
     * @return
     */
    private static HashMap<String, Object> generateRandomItems(Item[] items, int itemNum, int seed) {
        // 本轮生成的补给品组合信息
        List<Item> generatedItems = new ArrayList<>();
        // 剩余可生成的补给品数量
        int currentItemNum = itemNum;
        // 生成的补给品信息映射
        HashMap<String, Object> itemMap = new HashMap<>();

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

        // 本轮生成的补给品映射信息
        itemMap.put("itemNum", itemNum-currentItemNum);
        itemMap.put("itemList", generatedItems);

        return itemMap;
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
    public static <E> void printList(List<E> lists) {
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

    /**
     * 打印 Map 中的元素
     * @param map
     * @param <K>
     * @param <V>
     */
    public static <K, V> void printMap(Map<K, V> map) {
        System.out.println("{");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            String tmpName = (String) key;
            System.out.println(tmpName + ": " + value);
        }
        System.out.println("}");
    }
}
