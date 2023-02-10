package main.java.com.zmr.MyLeetCodeTests.My2022Lists.D12_27.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyMapTests
 * @Description Java Map使用
 * @Author zhumengren
 * @Date 2022/12/27 18:06
 * @Version 1.0
 **/
public class MyMapTests {
    public static void main(String[] args) {
        // 初始化哈希表
        HashMap<Integer, String> map = new HashMap<>();

        // 添加元素
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");

        // 查询操作
        map.get(1);

        // 删除操作
        map.remove(1);

        // 遍历hash表
        for (Map.Entry<Integer, String> kv: map.entrySet()) {
            System.out.println(kv.getKey() + "->" + kv.getValue());
        }

        // 单独遍历键 key
        for (int key : map.keySet()) {
            System.out.println(key);
        }

        // 单独遍历值 value
        for (String value : map.values()) {
            System.out.println(value);
        }
    }
}
