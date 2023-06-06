package com.zmr.NewBrushUpPlan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * @ClassName CompressString
 * @Description https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 * @Author zhumengren
 * @Version 1.0
 **/
public class CompressString {
    /***
     * @Description 压缩字符串(暴力解)
     * @param chars 
     * @return int
     */
    public static int compress(char[] chars) {
        // base case
        if (chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        // 辅助的 StringBuilder，用来接收压缩后的字符串的情况
        StringBuilder sb = new StringBuilder();
        
        // 声明一个临时的char，用来存放最后的那个char
        char tmpStr = 0;
        
        // 声明一个 map，用来存储char的key和value，其中key是character的值，value是key当前出现的数量
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            // 首先检查 tmpChar 中的字符是否为空字符
            if (!map.containsKey(chars[i])) {
                if (!map.keySet().isEmpty()) {
                    // 执行清空操作之前，先将map中的元素放置到StringBuilder中
                    sb.append(chars[i - 1]);
                    
                    // 如果值为1，则不需要存放1
                    if (map.get(chars[i - 1]) != 1) {
                        sb.append(map.get(chars[i - 1]));
                    }
                    
                    // 如果map中不为空，则移除map中的所有元素
                    map.clear();
                }
                tmpStr = chars[i];
                
                // 更新 map 中的键值对的值
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }

        // 最后一个元素也需要执行上面的操作
        // 执行清空操作之前，先将map中的元素放置到StringBuilder中
        sb.append(tmpStr);
        if (map.get(tmpStr) != 1) {
            sb.append(map.get(tmpStr));
        }

        
        chars = sb.toString().toCharArray();

        //System.out.println("处理完成前sb的值为：" + sb);
        //System.out.println("处理完成后chars数组的值为：" + Arrays.toString(chars));
        return sb.toString().length();
    }


    /***
     * @Description 压缩字符串 (原地算法)
     * 
     * 使用双指针的解法进行解决
     * 
     * @param chars
     * @return int
     */
    public static int compress01(char[] chars) {
        int n = chars.length;
        // 声明写指针、左指针
        int write = 0, left = 0;
        // 声明写指针
        for (int read = 0; read < n; read++) {
            // 当read指针到达末尾、或者当前在chars数组中的元素和下一个位置的元素的值不一致的时候 触发
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                // 写指针的值开始写
                chars[write++] = chars[read];
                int num = read - left + 1;
                
                // 特殊处理num = 1的情况
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                
                left = read + 1;
            }
        }
        return write;
    }

    /**
     * 翻转辅助方法
     * @param chars
     * @param left
     * @param right
     */
    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }


    /**
     * 随机生成一个char类型的数组
     * @param maxSize
     * @return
     */
    private static char[] generateChars(int maxSize) {
        char[] arr = new char[(int) (Math.random() * maxSize) + 1];
        // 初始化一个random对象
        Random random = new Random();
        // 随机生成char的值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (random.nextInt(128));
        }
        return arr;
    }


    /**
     * 拷贝一个char类型的数组
     * @param arr
     * @return
     */
    private static char[] copyCharArray(char[] arr) {
        if (arr == null) {
            return null;
        }
        
        char[] tmpArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        return tmpArr;
    }
    
    
    public static void main(String[] args) {
        //char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','a', 'b', 'c', 'a', 'a', 'c', 'c'};
        //char[] chars = {'a','a','b','b','c','c','c'};
        //System.out.println(compress(chars));
        //System.out.println(compress01(chars));
        
        
        int testTimes = 1000;
        int maxSize = 2000;


        System.out.println("测试开始！");

        for (int i = 0; i < testTimes; i++) {
            // 随机生成char数组，拷贝，比较返回值
            char[] arr = generateChars(maxSize);
            char[] arr1 = copyCharArray(arr);
            
            if (compress(arr) != compress01(arr1)) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束！");
        
    }
}
