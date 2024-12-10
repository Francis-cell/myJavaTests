package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.LeetCodePractice.LeetCode100;

import com.zmr.MyUtils.TestTools.PrintUtils.PrintUtils;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        // 1、先将 strs 数组中相同长度的元素集中到一块儿
        String[] compareArr = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String currentStr = strs[i];
            char[] chars = currentStr.toCharArray();
            // 排序
            Arrays.sort(chars);
            // 放回到比较数组中
            compareArr[i] = new String(chars);
        }
        
        // 2、在 compareArr 使用 HashTable 找相同的元素进行集中
        Map<String, ArrayList<String>> hashTable = new HashMap<>();
        for (int i = 0; i < compareArr.length; i++) {
            // 如果已经存在了，则将对应的元素获取出来，将原本数组中元素丢进去
            if (hashTable.containsKey(compareArr[i])) {
                ArrayList<String> findList = hashTable.get(compareArr[i]);
                findList.add(strs[i]);
                hashTable.put(compareArr[i], findList);
                continue;
            }
            ArrayList<String> tmpList = new ArrayList<>();
            tmpList.add(strs[i]);
            hashTable.put(compareArr[i], tmpList);
        }
        
        // 3、将 hashTable 中的结果进行处理
        for (ArrayList<String> list : hashTable.values()) {
            ans.add(list);
        }
        return ans;
    }

    /**
     * <p> 官方题解 </p>
      * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsSample(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        // aet, aet, ant, aet, ant, abt, 
        String[] strs1 = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        // [[""]]
        String[] strs2 = new String[] {""};
        // [["a"]]
        String[] strs3 = new String[] {"a"};

        // PrintUtils.printArr(groupAnagrams(strs1));

        // PrintUtilsImpl.printComplicatedList(groupAnagrams(strs1));
        // PrintUtilsImpl.printComplicatedList(groupAnagrams(strs2));
        PrintUtils.printComplicatedList(groupAnagrams(strs3));
    }
}
