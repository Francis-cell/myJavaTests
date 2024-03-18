package com.zmr.LearningFiles.OwnLearning.MyLeetCodeTests.My2022Lists.D9_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 给定一个非负整数，至多交换一次数字中的任意两位，返回你能得到的最大值
 * eg:2736--》7236
 *    9973不必交换
 * 数字范围: [0-10^8]                                 100000000
 * Java中int的范围：-2^31--2^31-1  ---- -2147483648——2147483647
 * 由此可见此处给出的数字范围还在int的范围之内
 **/
public class ChangeNumberToMax {
    // 一个更好的思路
    // 1、将传入的那一串数字拆分成数组arr1
    // 2、将拆分之后的数组进行从大到小的排序arr2
    // 3、依次比较两个数组的元素，当n位开始两个数组的数字不在相同时(0<= n <= arr1.length()-1)，后面的数字按照
    // 时间复杂度O(4n); 空间复杂度O(2n+3);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 0、拆分传入的数据num
        // 思路：1、将num中的数字全部转换成单位的数值，然后进行排序
        ArrayList<Integer> intArrs = new ArrayList<>();
        int len = Integer.toString(num).length();
        for (int i = 0; i < len; i++) {
            intArrs.add(num % 10);
            num = num / 10;
        }
        // 原本产生的intArrs的值就是一个逆序的ArrayList，需要转换顺序
        Collections.reverse(intArrs);
        // 查看数据
        //System.out.println(intArrs);

        // 1、两个数组进行排序并比较
        List<String> intArrsTemp = new ArrayList<>();
        intArrs.forEach(item->{
            intArrsTemp.add(item+"");
        });

        // 将intArrsTemp列表进行排序(从大到小元素的排序)
        // ①排序ArrayList
        Collections.sort(intArrsTemp);
        // ②逆序ArrayList
        Collections.reverse(intArrsTemp);
        System.out.println("排序之前的arrayList的值:" + intArrs);
        System.out.println("排序之后的arrayList的值:" + intArrsTemp);

        // 比较两个arrayList中的值，指导找到第n位数值不同值的下标点
        // 用于存储不同元素的下标的值，如果值为-1，则证明没有不同的元素的值，则不需要进行排序；
        // 反之则需要将从第indexTemp位开始的元素执行下面的操作（获取串中最大的元素，然后执行交换）
        int indexTemp = -1;
        for (int i = 0; i < intArrs.size(); i++) {
            if (!(intArrs.get(i)+"").equals(intArrsTemp.get(i))) {
                indexTemp = i;
                break;
            }
        }
        System.out.println("indexTemp的值为：" + indexTemp);
        ArrayList<Integer> lastArrs = new ArrayList<>();
        if (indexTemp == -1) {
            System.out.println("不需要转换元素!");
            return;
        } else {
            // 从0-indexTemp的值取排序后的ArrayList(intArrsTemp)中元素的值
            for (int i = 0; i < indexTemp; i++) {
                // intArrsTemp中的值为String类型的，需要转换成Integer类型的才能使用
                lastArrs.add(Integer.valueOf(intArrsTemp.get(i)));
            }
            // 从indexTemp-intArrs.size()后的值取原本的ArrayList(intArrs)中的值
            // 将剩下的元素放置到一个arrayList中
            for (int i = indexTemp; i < intArrs.size(); i++) {
                lastArrs.add(intArrs.get(i));
            }
        }
        System.out.println("lastArrs的值为:" + lastArrs);
        // 2、获取最大的数字，然后将最后一个最大的数字进行位置交换
        Integer max = Collections.max(lastArrs);
        System.out.println("max的值为：" + max);
        // 1、如果第一位不是最大的数字，将最大的数字和第一位进行交换即可(注意是最后一个最大的数字交换过来)
        for (int i = len-1; i > 0; i--) {
            if (lastArrs.get(i).equals(max)) {
                lastArrs.set(i, intArrs.get(indexTemp));
                lastArrs.set(indexTemp, max);
                break;
            }
        }
        System.out.println("最终的值为：" + lastArrs.toString());
        return;
    }
}
