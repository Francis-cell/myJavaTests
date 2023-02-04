package LearningFiles.MyAlgorithmTests.MyHashMapExamples;

import java.util.HashMap;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 小程序-查看hash表中使用的”引用传递“还是”值传递“
 * @date 2023/2/2 20:18
 */
public class MyHashValCurTests {
    public static class Zhu {
        Integer val;
        public Zhu(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        // 值传递(基本数据类型、String类型)
        HashMap<Integer, String> map = new HashMap<>();
        Integer a = 20000;
        Integer b = 20000;
        // false
        System.out.println(a == b);
        
        map.put(a, "111");
        // true
        System.out.println(map.containsKey(b));
        
        
        // 引用传递
        Zhu z1 = new Zhu(1);
        Zhu z2 = new Zhu(1);
        HashMap<Zhu, String> map2 = new HashMap<>();
        map2.put(z1, "123");
        // false
        System.out.println(map2.containsKey(z2));
    }
}
