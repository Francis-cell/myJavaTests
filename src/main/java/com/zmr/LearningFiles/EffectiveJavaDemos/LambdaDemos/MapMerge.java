package com.zmr.LearningFiles.EffectiveJavaDemos.LambdaDemos;

import java.util.HashMap;
import java.util.Map;

public class MapMerge {
    public static void main(String[] args) {
        Integer a[] = new Integer[] {1, 2, 3, 4, 5, 6, 1, 3, 4, 2, 3, 1, 2, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer intVal : a) {
            // 如果指定的键没有映射，该方法就会插入指定值；
            // 如果有映射存在，merge 方法就会将指定的函数应用到当前值和指定值上，并用结果覆盖当前值
            // map.merge(intVal, 1, (count, incr) -> count + incr);

            // 使用 Integer 下的 sum 方法替代上面的实现
            map.merge(intVal, 1, Integer::sum);
        }
        System.out.println(map);
    }
}
