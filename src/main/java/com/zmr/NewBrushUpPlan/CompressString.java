package com.zmr.NewBrushUpPlan;

import java.util.HashMap;

/**
 * @ClassName CompressString
 * @Description https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 * @Author zhumengren
 * @Version 1.0
 **/
public class CompressString {
    /***
     * @Description 压缩字符串(暴力解)
     * @param strArr 
     * @return int
     */
    public static int compress(String[] strArr) {
        // base case
        if (strArr.length == 0) {
            return 0;
        }

        if (strArr.length == 1) {
            return 1;
        }

        // 辅助的 StringBuilder，用来接收压缩后的字符串的情况
        StringBuilder sb = new StringBuilder();
        
        // 声明一个临时的char，用来存放最后的那个char
        String tmpStr = "";
        
        // 声明一个 map，用来存储char的key和value，其中key是character的值，value是key当前出现的数量
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            // 首先检查 tmpChar 中的字符是否为空字符
            if (!map.containsKey(strArr[i])) {
                if (!map.keySet().isEmpty()) {
                    // 执行清空操作之前，先将map中的元素放置到StringBuilder中
                    sb.append(strArr[i - 1]);
                    
                    // 如果值为1，则不需要存放1
                    if (map.get(strArr[i - 1]) != 1) {
                        sb.append(map.get(strArr[i - 1]));
                    }
                    
                    // 如果map中不为空，则移除map中的所有元素
                    map.clear();
                }
                tmpStr = strArr[i];
                
                // 更新 map 中的键值对的值
                map.put(strArr[i], 1);
            } else {
                map.put(strArr[i], map.get(strArr[i]) + 1);
            }
        }

        // 最后一个元素也需要执行上面的操作
        // 执行清空操作之前，先将map中的元素放置到StringBuilder中
        sb.append(tmpStr);
        if (map.get(tmpStr) != 1) {
            sb.append(map.get(tmpStr));
        }

        System.out.println("处理完成前sb的值为：" + sb);
        return sb.toString().length();
    }


    /***
     * @Description 压缩字符串
     * @param strArr
     * @return int
     */
    public static int compress01(String[] strArr) {
        // base case
        if (strArr.length == 0) {
            return 0;
        }

        if (strArr.length == 1) {
            return 1;
        }
        
        return 0;
    }
    
    
    public static void main(String[] args) {
        String[] chars = new String[] {"a","b","b","b","b","b","b","b","b","b","b","b","b", "a", "b", "c", "a", "a", "c", "c"};
        System.out.println(compress(chars));
    }
}
