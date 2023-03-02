package main.java.com.zmr.LearningFiles.MyAlgorithmTests.MyHashMapExamples;

import java.util.TreeMap;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 有序表常用方法 TreeMap
 * @date 2023/2/2 20:49
 */
public class MySortedTreeTests {
    public static class Zhu {
        Integer val;
        public Zhu(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        // TreeMap   有序表：接口名
        // 红黑树、avl树、sb树、跳表
        // 时间复杂度o(logN)

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        
        treeMap.put(5, "5");
        treeMap.put(4, "4");
        treeMap.put(9, "9");
        treeMap.put(6, "6");
        treeMap.put(7, "7");
        treeMap.put(2, "2");
        treeMap.put(0, "0");
        
        // 判断元素是否在有序树中存在
        // true
        System.out.println(treeMap.containsKey(2));
        // false
        System.out.println(treeMap.containsKey(1));
        
        // 获取值
        // 2
        System.out.println(treeMap.get(2));
        // null
        System.out.println(treeMap.get(1));
        
        // 修改值
        treeMap.put(2, "3");
        // 3
        System.out.println(treeMap.get(2));
        
        // 删除值
        treeMap.remove(0);
        // null
        System.out.println(treeMap.get(0));
        
        
        // 新功能
        // 获取最大值
        // 2
        System.out.println(treeMap.firstKey());
        // 获取最小值
        // 9
        System.out.println(treeMap.lastKey());
        // 获取 <= 4 最大的值
        // 4
        System.out.println(treeMap.floorKey(4));
        // 获取 >= 4 最小的值
        // 4
        System.out.println(treeMap.ceilingKey(4));
        
        
        
        // TODO--基本类型treeMap天然具备排序；
        //  非基本类型必须传入比较规则（比较器），否则将会报错
        TreeMap<Zhu, String> treeMap2 = new TreeMap<>();
        // 触发报错
        treeMap2.put(new Zhu(1), "1");
        treeMap2.put(new Zhu(2), "2");
    }
}
