package com.zmr.LearningFiles.OwnLearning.MyAlgorithmTests.DynamicProgramming;

/**
 * @ClassName CardsInLine
 * @Description 
 * 题目描述：
 * 先手（A）后手（B）从一行纸牌中拿数字（最左侧、最右侧）; 
 * A、B都绝顶聪明;
 * 获取最后获胜者的分数是多少
 **/
public class CardsInLine {
    /** 1、暴力递归解法 */
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 先手
        int first = f1(arr, 0, arr.length - 1);
        // 后手
        int second = g1(arr, 0, arr.length - 1);
        System.out.println("first: " + first);
        System.out.println("second: " + second);
        return Math.max(first, second);
    }
    
    /** 先手函数 */
    public static int f1(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            return arr[L];
        }
        // 先手获取的分数等于当前获取的值 and 抽取数字之后，作为后手出现时能获取的分数的最大值
        // 抽取最左侧数字
        int p1 = arr[L] + g1(arr, L + 1, R);
        // 抽取最右侧数字
        int p2 = arr[R] + g1(arr, L, R - 1);
        return Math.max(p1, p2);
    }
    
    /** 后手函数 */
    public static int g1(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            // 只剩一张数字的时候，作为后手，所以抽不到数字了
            return 0;
        }
        // 先手拿走了最左侧数字时获取的最大值(后手可以获取的值)
        int p1 = f1(arr, L + 1, R);
        // 先手拿走了最右侧数字时获取的最大值(后手可以获取的值)
        int p2 = f1(arr, L, R - 1);
        // 因为是由先手决定的结果，而先手只会让后手获取最小值
        return Math.min(p1, p2);
    }
    
    
    /** 
     * 动态第一次优化--有利可图
     * f(L, R) 
     * ①、g(L + 1, R)  ②、g(L, R - 1)
     * ①、f(L + 1, R - 1) & f(L + 2, R)  ②、f(L + 1, R - 1) & f(L, R - 2)
     * 可以看到f(L + 1, R - 1)一共出现了2次，所以可以进行一次优化
     */
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int N = arr.length;
        
        // 先手表
        int[][] fArr = new int[N][N];
        // 后手表
        int[][] gArr = new int[N][N];
        // 初始化里面的值为-1，java初始化int数组时里面的值为0
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fArr[i][j] = -1;
                gArr[i][j] = -1;
            }
        }
        
        // 先手
        int first = f2(arr, 0, arr.length - 1, fArr, gArr);
        // 后手
        int second = g2(arr, 0, arr.length - 1, fArr, gArr);
        System.out.println("first: " + first);
        System.out.println("second: " + second);
        return Math.max(first, second);
    }

    /** 先手函数 */
    public static int f2(int[] arr, int L, int R, int[][] fArr, int[][] gArr) {
        // 如果缓存中查到了数据
        if (fArr[L][R] != -1) {
            return fArr[L][R];
        }
        
        int ans = 0;
        // base case
        if (L == R) {
            ans = arr[L];
        } else {
            // 先手获取的分数等于当前获取的值 and 抽取数字之后，作为后手出现时能获取的分数的最大值
            // 抽取最左侧数字
            int p1 = arr[L] + g2(arr, L + 1, R, fArr, gArr);
            // 抽取最右侧数字
            int p2 = arr[R] + g2(arr, L, R - 1, fArr, gArr);
            ans = Math.max(p1, p2);
        }
        return ans;
    }

    /** 后手函数 */
    public static int g2(int[] arr, int L, int R, int[][] fArr, int[][] gArr) {
        // 如果在缓存中查到了数据
        if (gArr[L][R] != -1) {
            return gArr[L][R];
        }
        
        int ans = 0;
        // base case
        if (L == R) {
            // 只剩一张数字的时候，作为后手，所以抽不到数字了
            ans = 0;
        } else {
            // 先手拿走了最左侧数字时获取的最大值(后手可以获取的值)
            int p1 = f2(arr, L + 1, R, fArr, gArr);
            // 先手拿走了最右侧数字时获取的最大值(后手可以获取的值)
            int p2 = f2(arr, L, R - 1, fArr, gArr);
            // 因为是由先手决定的结果，而先手只会让后手获取最小值
            ans = Math.min(p1, p2);
        }
        return ans;
    }

    
    /** 第二次优化，使用动态规划表进行优化 */
    public static int win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int N = arr.length;
        // 先手表
        int[][] fArr = new int[N][N];
        // 后手表
        int[][] gArr = new int[N][N];
        
        // 1、初始化f表和g表对角线位置数据
        for (int i = 0; i < N; i++) {
            fArr[i][i] = arr[i];
            // g表默认值为0，所以无需初始化就可以使用
        }
        
        // 2、生成f表和g表其他位置数据
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fArr[L][R] = Math.max(arr[L] + gArr[L + 1][R], arr[R] + gArr[L][R - 1]);
                gArr[L][R] = Math.min(fArr[L + 1][R], fArr[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fArr[0][N - 1], gArr[0][N - 1]);
    }



    public static void main(String[] args) {
        int[] arr = new int[] {10, 5, 7, 20, 8, 30, 50, 10, 4, 3};
        //int[] arr = new int[] {10, 100, 10};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }
}
