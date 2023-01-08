package MyLeetCodeTests.My2022Lists.ListNodeTests;

import java.util.Arrays;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @description 简单实现list列表（使用数组实现）
 * @date 2022/12/25 14:28
 */
public class MyList {
    /** 数组(用于存储列表元素) */
    private int[] nums;
    /** 列表容量(这里初始化长度为10) */
    private int capacity;
    /** 列表长度(当前列表中元素的数量) */
    private int size = 0;
    /** 每次列表扩容的倍数(这里选择两倍) */
    private int extendRatio = 2;

    /** 构造函数 */
    public MyList() {
        nums = new int[capacity];
    }

    /** 获取列表的长度 */
    public int capacity() {
        return size;
    }

    /** 访问元素 */
    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return nums[index];
    }

    /** 更新元素 */
    public void set(int index, int val) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        nums[index] = val;
    }

    /** 尾部添加元素 */
    public void add(int val) {
        // 当元素数量超过列表最大容量之后，触发扩容
        if (size == capacity()) {
            // 触发扩容
            extendCapacity();
        }
        nums[size] = val;
        // 更新元素数量
        size++;
    }

    /** 中间插入元素 */
    public void insert(int index, int val) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        // 如果元素数量超过列表最大容量，触发扩容
        if (size == capacity()) {
            // 触发扩容
            extendCapacity();
        }
        // 将被插入节点之后的元素全部向后移动一位
        for (int j = size-1; j >= index; j--) {
            nums[j+1] = nums[j];
        }
        // 插入新元素
        nums[index] = val;
        // 更新元素数量
        size++;
    }

    /** 删除元素 */
    public int delete(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        // 将被删除节点的元素存储起来，其余的值全部向前移动一位
        int val = nums[index];
        for (int j = index; j < size; j++) {
            nums[j-1] = nums[j];
        }
        // 更新元素数量
        size--;
        return val;
    }

    /** 列表扩容 */
    public void extendCapacity() {
        // 新建一个长度为size的数组，并将原数组拷贝给新数组
        nums = Arrays.copyOf(nums, nums.length * extendRatio);
        // 更新列表容量
        capacity = nums.length;
    }
}
