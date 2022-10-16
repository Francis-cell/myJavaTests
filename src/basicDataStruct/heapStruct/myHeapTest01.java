package basicDataStruct.heapStruct;

import java.util.Arrays;

/**
 * @ClassName myHeapTest01
 * @Description 堆测试01
 * @Author zhumengren
 * @Date 2022/10/16 14:41
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class myHeapTest01 {

    /**
     * 上浮调整(使用最小堆)
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        // 找到最后一个叶子节点
        int childIndex = array.length - 1;
        // 最后一个叶子节点的父节点的下标为
        int parentIndex = (childIndex - 1) / 2;
        // 使用temp保存子节点的值，用于最后的赋值
        int temp = array[childIndex];
        // 开始执行赋值操作(此处无需真正交换，只需要进行赋值即可)
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        // 因为是上浮操作，所以是子节点会存在空白的位置
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 要"下沉"的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，那么定位到右孩子
            if (childIndex + 1 < length && array[childIndex] > array[childIndex + 1]) {
                childIndex ++;
            }
            // 如果父节点小于拥有较小值的孩子节点的值，那么直接跳出
            if (temp < array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        // 因为是下沉操作，所以为子节点会存在空白的位置
        array[parentIndex] = temp;
    }

    /** 构建堆
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，开始执行下沉操作
        for (int i = (array.length - 2) / 2; i >= 0 ; i--) {
            downAdjust(array, i, array.length);
        }
    }


    public static void main(String[] args) {
        // 声明一个二叉树的array
        int[] array = new int[] {1,3,2,6,5,4,7,2,6,10};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {5,6,7,3,4,8,1,2,9,0};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
