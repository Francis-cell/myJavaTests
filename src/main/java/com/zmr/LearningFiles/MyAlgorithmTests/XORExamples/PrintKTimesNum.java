package main.java.com.zmr.LearningFiles.MyAlgorithmTests.XORExamples;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 数组arr中有一个数出现了K次，其余数出现了M次，其中M!=1， M>K，找到这个出现了K次的数
 * @date 2023/1/31 20:00
 */
public class PrintKTimesNum {
    /** 使用经典解作为对数器参考的方法 */
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }


    /** 请保证arr中，只有一种数出现了K次，其他数出现了M次 */
    public static int onlyKTimes(int[] arr, int k, int m) {
        // 初始化一个长度为32的数组
        int[] t = new int[32];
        // t[0] 0位置上的1出现的次数
        // t[i] i位置上的1出现的次数
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                // 如果num在第i位上的值为1，则给t[i] + 1
                if (((num >> i)&1) == 1) {
                    t[i] += 1;
                }
            }
        }
        // 初始化ans的值
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            // 出现K次的数，在第i位上有1
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }


    /** 对数器（1、先假设对数器写出来了）
     * @description 随机数组生成方法
     * maxKinds: 数组中数据的种类数量
     * range: 数值的范围
     * k: 其中一个数出现了k次
     * m: 另外一个数出现了m次
     */
    public static int[] randomArr(int maxKinds, int range, int k, int m) {
        // 设置一个要出现k次的数
        int ktimeNum = randomNum(range);
        // 当前要生成的随机数组中数的种类 (这里最少要为2)
        int numKinds = (int)(Math.random() * maxKinds) + 2;
        // 计算生成的随机数组的长度
        // 有一种数有k次，其余数据的次数为m， arrLen = 1 * k + m * (numKinds - 1)
        int[] arr = new int[k + m * (numKinds - 1)];

        // TODO--1、将ktimeNum填进去
        // index从0开始
        int index = 0;
        // 填入k个ktimeNum进入数组
        for(;index < k; index++) {
            arr[index] = ktimeNum;
        }

        // TODO--2、填入剩余的数据
        numKinds--;
        // TODO---坑！！！建立一个HashSet
        HashSet<Integer> set = new HashSet<>();
        // 将ktimeNum添加进去
        set.add(ktimeNum);
        while (numKinds != 0) {
            // 开始随机剩余要填入的数
            int curNum = 0;
            // TODO---注意！！！如果随机出来的数在set中已经存在了，那么重新随机
            do {
                curNum = randomNum(range);
            } while (set.contains(curNum));
            // 将新random出来的数据添加到set中去
            set.add(curNum);
            // 剩余的种类数-1
            numKinds--;
            // 向正在随机的数组中填入当前随机出来的新的数
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }

        // ---------随机的arr已经初始化完成了-------------
        // 打乱数组中的数据
        for (int i = 0; i < arr.length; i++) {
            // i位置的数和j位置的数随机进行交换 【Math.random() * arr.length生成的是0~N-1之间的数据】
            int j = (int)(Math.random() * arr.length);
            // 执行交换数据
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

    /**
     * @description 生成随机数的方法
     * @return 返回[-range, +range]之间的一个值
     */
    public static int randomNum(int range) {
        return ((int)(Math.random() * range) + 1) - ((int)(Math.random() * range) + 1);
    }




    /** 2、准备main函数 */
    public static void main(String[] args) {
        // 数组中数据的种类数量
        int kinds = 10;
        // 数组的范围在-200~200之间
        int range = 200;
        // 测试次数
        int testTime = 100000;

        // 设置一个限制k和m的值
        int max = 9;

        System.out.println("测试开始！！！");

        // 每次测试都要生成一个随机数组
        for (int i = 0; i < testTime; i++) {
            // 初始化k和m的值
            // 值在 1~9 之间 【Math.random() * max 的值在0~8之间】
            int a = (int)(Math.random() * max) + 1;
            int b = (int)(Math.random() * max) + 1;

            // k是a和b之间的最小值
            int k = Math.min(a, b);
            // m是a和b之间的最大值
            int m = Math.max(a, b);
            // TODO 【如果a==b，则将b的值加1】 (要求 k < m)
            if (k == m) {
                m++;
            }

            // 生成数组
            int[] arr = randomArr(kinds, range, k, m);

            // 使用HashMap的方式生成答案1
            int ans1 = test(arr, k, m);
            // 使用自己写的方式生成答案2
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错了！");
                return;
            }
        }

        System.out.println("测试结束！！！");
    }
}
