package MyLeetCodeTests.D12_29.find;

/**
 * @ClassName BinaryFind
 * @Description 二分查找实现
 * @Author zhumengren
 * @Date 2022/12/29 18:49
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class BinarySearch {
    /** 二分查找(双闭区间)--建议使用的方式 */
    int binarySearchArrFirst(int[] nums, int target) {
        // 初始化双闭区间[0, n-1], 即i, j分别指向数组首元素、尾元素
        int i = 0, j = nums.length-1;
        // 循环，当搜索区间为空时跳出(当 i > j时搜索区间为空)
        while (i <= j) {
            // 计算中间点索引
            int m = (i + j) / 2;
            // 判断中间索引位置的元素的值和目标值的大小关系
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                return m;
            }
        }
        // 未查找到元素,返回-1
        return -1;
    }

    /** 二分查找(左闭右开) */
    int binarySearchArrSecond(int[] nums, int target) {
        // 初始化左闭右开[0, n)，即i, j分别指向数组首元素，尾元素+1
        int i = 0, j = nums.length;
        // 循环，当搜索区间为空时跳出搜索
        while (i < j) {
            // TODO--计算i和j的中间点的索引位置m(计算中间点坐标的方式--> (i + j) / 2 )
            int m = (i + j) / 2;
            // 说明目标元素在中点m右侧
            if (nums[m] < target) {
                i = m + 1;
            }
            // 说明目标元素在中点m左侧
            else if (nums[m] > target) {
                j = m;
            } else {
                return m;
            }
        }
        // 说明没有查找到元素
        return -1;
    }


    public static void main(String[] args) {
        // TODO--说明
        // 如果加法i+j的结果可能超过int类型的取值范围，那么中点m在取值时 m = (i + j) / 2 时就也可能会超过int的取值范围
        // TODO--更换写法---
        // int m = i + (j - i) / 2
    }
}
