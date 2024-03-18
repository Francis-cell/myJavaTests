package com.zmr.LearningFiles.OwnLearning.NewBrushUpPlan;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/6/3 18:37
 * @description https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 */
public class MoveZeroes {
    /**
     * 移动零(暴力解)
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    swapArrayElements(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 优化后的暴力解
     * @param nums
     */
    public static void moveZeroes02(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swapArrayElements(nums, i, j);
                        break;
                    }
                }
            }
        }
    }


    /**
     * 交换数组arr在a和b下标位置的元素
     * @param arr
     * @param a
     * @param b
     */
    private static void swapArrayElements(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



    /**
     * 移动零(不保持非0元素的相对顺序)
     * @param nums
     */
    public static void moveZeroes01(int[] nums) {
        // 双指针的解法
        int right = nums.length - 1;
        // 如果left指针指向的元素的值为0，right指针指向的元素的值不为0，则执行交换
        // 当left >= right 的时候结束

        for (int left = 0; left < right; ) {
            if (nums[left] != 0) {
                left++;
            } else {
                // left位置已经找到了为0的元素
                // 寻找right不为0的元素
                while (nums[right] == 0) {
                    right--;
                }
                // 执行left和right元素的交换
                if (left < right) {
                    swapArrayElements(nums, left, right);
                    // 元素交换完毕之后，left 向右移动一位，right向左移动一位
                    left++;
                    right--;
                }
            }
        }
    }

    
    /**
     * 移动零(保持非零元素的相对顺序)
     * @param nums
     */
    public static void moveZeroes03(int[] nums) {
        // 定义第一个非0的指针位置
        int cur = 0;
        // 开始收集不是0的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        
        // 剩余的位置自然全为0了
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    

    
    
    
    /**
     * 数组拷贝
     * @param arr
     * @return
     */
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] tmpArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        return tmpArr;
    }


    /**
     * 随机初始化数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        }
        return arr;
    }


    /**
     * 检查两个数组中的最后的0的数量是否一致(不保持0的相对顺序的方式，对数器使用的方法)
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean checkNumberOfZeroForArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        
        int count = 0;
        int startIndex = 0;
        
        int count1 = 0;
        int startIndex1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                count++;
            } else {
                startIndex++;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == 0) {
                count1++;
            } else {
                startIndex1++;
            }
        }
        
        if (count != count1) {
            return false;
        }


        for (int i = startIndex; i < arr1.length; i++) {
            if (arr1[i] != 0) {
                return false;
            } else {
                count--;
            }
        }

        for (int i = startIndex; i < arr2.length; i++) {
            if (arr2[i] != 0) {
                return false;
            } else {
                count1--;
            }
        }
        
        if (count != count1 || count != 0) {
            return false;
        }
        
        
        return true;
    }


    /**
     * 判断两个数组arr1和arr2中的值是否一致
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqualsArray(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
            return false;
        }
        
        if (arr1 == null && arr2 == null) {
            return true;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    


    public static void main(String[] args) {
        //int[] nums = new int[] {-208, 415, 85, -27, 449};
        //int[] nums1 = copyArray(nums);
        //moveZeroes(nums);
        //moveZeroes01(nums1);
        //System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(nums1));
        //
        //System.out.println(checkNumberOfZeroForArrays(nums, nums1));
        
        
        int testTimes = 10000;
        int maxSize = 1000;
        int maxValue = 1000;

        System.out.println("测试开始！");

        for (int i = 0; i < testTimes; i++) {
            // 随机数组，拷贝数组，计算，比较最后的0的数量是否一致
            int[] arr = generateArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);

            moveZeroes(arr);
            moveZeroes02(arr1);
            moveZeroes03(arr2);

            // 比较最后的0的数量是否一致
            //if (!checkNumberOfZeroForArrays(arr, arr1)) {
            //    System.out.println("出错了！");
            //    System.out.println(Arrays.toString(arr2));
            //    break;
            //}
            
            if (!isEqualsArray(arr, arr1) || !isEqualsArray(arr, arr2)) {
                System.out.println("出错了！");  
                break;
            }
        }

        System.out.println("测试结束！");
    }
}
