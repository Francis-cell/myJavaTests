package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlaning.Search.DFS;


import java.util.Stack;

/**
 * <p> 省份数量 </p>
 * https://leetcode.cn/problems/number-of-provinces/description/
 */
public class ProvinceNumerDemo {
    /** 深度优先搜索策略求解-错误 */
    public static final int[][] DIRECTION = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }

        int ans = 0;

        int rows = isConnected.length;
        // 被访问过的城市的记录
        boolean[] visited = new boolean[rows];

        for (int row = 0; row < rows; row++) {
            if (!visited[row]) {
                dfs(isConnected, row, visited);
                ans++;
            }
        }
        return ans;
    }

    public static void dfs(int[][] isConnected, int row, boolean[] visited) {
        int cols = isConnected[0].length;
        for (int col = 0; col < cols; col++) {
            if (isConnected[row][col] == 1 && !visited[col]) {
                // 将当前节点置为访问过的状态
                visited[col] = true;
                dfs(isConnected, col, visited);
            }
        }
    }


    /**
     * 暴力解
     * 思路：一个栈用来搜索，循环查找
     * @param isConnected
     * @return
     */
    public static int violentAnswer(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }

        int rows = isConnected.length;
        int cols = isConnected[0].length;

        int ans = 0;

        // 已搜索序列(如果已经查看过，则值为 true)
        boolean[] visited = new boolean[rows];
        // 数据存储栈
        Stack<Integer> stack = new Stack<>();

        for (int row = 0; row < rows; row++) {
            boolean flag = false;
            for (int col = 0; col < cols; col++) {
                // 忽略对角线上的数据；没有遍历过的数据；
                if (row != col && !visited[col] && isConnected[row][col] == 1) {
                    // 说明有元素入栈了
                    flag = true;
                    // 防止重复检查
                    visited[row] = true;
                    // 元素入栈(列下标)
                    stack.push(col);
                    visited[col] = true;
                }
            }

            while (!stack.isEmpty()) {
                int currentIndex = stack.pop();
                // 查看当前 currentIndex 行中相连的元素
                for (int col = 0; col < cols; col++) {
                    if (currentIndex != col && !visited[col] && isConnected[currentIndex][col] == 1) {
                        stack.push(col);
                        visited[col] = true;
                    }
                }
            }
            // 有过入栈操作或者当前元素独立为块儿
            if (flag || isConnected[row][row] == 1 && !visited[row]) {
                ans++;
            }
        }

        return ans;
    }


    /**
     * 随机数组
     * @param maxSize
     * @return
     */
    public static int[][] generateRandomArray(int maxSize) {
        int size = (int) (Math.random() * (maxSize + 1));
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                // 对角线数据必为1
                if (i == j) {
                    arr[i][j] = 1;
                } else {
                    if (Math.random() <= 0.5) {
                        arr[i][j] = 0;
                        arr[j][i] = 0;
                    } else {
                        arr[i][j] = 1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 数组比较
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean compareArr(int[][] arr1, int[][] arr2) {
        if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] copyArr(int[][] arr) {
        if (arr == null || arr[0] == null || arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        // 检查arr是否为空数组
        if (arr.length == 0) {
            return new int[0][];
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = arr[i][j];
            }
        }
        return ans;
    }

    public static void printArr(int[][] arr) {
        for (int[] arrInner : arr) {
            for (int val : arrInner) {
                System.out.printf(val + ", ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int testTimes = 100000;
        int maxSize = 200;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            // 随机数组
            int[][] arr = generateRandomArray(maxSize);
            int[][] arr1 = copyArr(arr);

            if (findCircleNum(arr) != violentAnswer(arr1)) {
                System.out.println("出错了！");
                printArr(arr);
                break;
            }
        }
        System.out.println("测试结束！");




        // int[][] arr = new int[][] {
        //         {1, 0, 0, 1},
        //         {0, 1, 1, 0},
        //         {0, 1, 1, 1},
        //         {1, 0, 1, 1}
        // };
        // int[][] arr = new int[][] {
        //         {1, 0, 0, 0},
        //         {0, 1, 1, 0},
        //         {0, 1, 1, 1},
        //         {0, 0, 1, 1}
        // };
        // int[][] arr = new int[][] {
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0},
        //         {0, 0, 0, 0, 0, 0, 0, 0}
        // };
        // System.out.println(findCircleNum(arr));
        // System.out.println(findCircleNum1(arr));
        // System.out.println(violentAnswer(arr));
    }
}
