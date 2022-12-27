package MyLeetCodeTests.D12_27.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyMap
 * @Description 自定义实现Map(初始化大小设置为100)
 * @Author zhumengren
 * @Date 2022/12/27 18:24
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyMap {
    /** 定义Map单个键值对辅助类 */
    class Entry {
        // 键
        public int key;
        // 值
        public String val;

        public Entry(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    /** 基于数组实现的HashMap */
    class ArrayHashMap{
        // 定义存储数据的桶对象
        private List<Entry> bucket;

        public ArrayHashMap() {
            // 初始化一个长度为100的桶（数组）
            bucket = new ArrayList<>(100);
            // 将所有的元素的值都初始化为null
            for (int i = 0; i < bucket.size(); i++) {
                bucket.add(null);
            }
        }

        /** 哈希函数 */
        private int hashFunc(int key) {
            int index = key % 100;
            return index;
        }

        /** 查询操作 */
        public String get(int key) {
            int index = hashFunc(key);
            // 获取对应index下的对象
            Entry pair = bucket.get(index);
            if (pair == null) {
                return null;
            }
            return pair.val;
        }

        /** 添加操作 */
        public void insert(int key, String val) {
            Entry pair = new Entry(key, val);
            int index = hashFunc(key);
            bucket.set(index, pair);
        }

        /** 删除操作 */
        public void remove(int key) {
            int index = hashFunc(key);
            bucket.set(index, null);
        }
    }
}
