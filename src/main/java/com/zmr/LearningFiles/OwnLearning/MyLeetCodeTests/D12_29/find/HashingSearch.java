package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.D12_29.find;

import java.util.Map;

/**
 * @ClassName HashingSearch
 * @Description 哈希查找实现
 * @Author zhumengren
 * @Date 2022/12/29 19:24

 * @Version 1.0
 **/
public class HashingSearch {
    class ListNode {
        int val;
        ListNode next;

        ListNode (int val) {
            this.val = val;
        }
    }

    /** hash查找--数组 */
    int hashingSearchInt (Map<Integer, Integer> map, int target) {
        // 哈希表的key: 目标元素, value: 索引
        // 若哈希表中无此key，返回-1
        return map.getOrDefault(target, -1);
    }

    /** hash查找--链表 */
    ListNode hashingSearchNode (Map<Integer, ListNode> map, int target) {
        // 哈希表的 key: 目标结点值, value: 结点对象
        // 若哈希表中无此 key, 返回 null
        return map.getOrDefault(target, null);
    }

    public static void main(String[] args) {

    }
}
