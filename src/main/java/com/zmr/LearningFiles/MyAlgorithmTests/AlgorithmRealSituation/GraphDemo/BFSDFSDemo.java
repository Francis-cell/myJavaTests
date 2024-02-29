package com.zmr.LearningFiles.MyAlgorithmTests.AlgorithmRealSituation.GraphDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 深度优先 </p>
 */
public class BFSDFSDemo {
    // /**
    //  * <p> 使用深度优先的策略 </p>
    //  * @param board
    //  * @param word
    //  * @return
    //  */
    // public static boolean exists(char[][] board, String word) {
    //     // 数据查找特征：
    //     // 1、如果数据在第一行
    //     // ①、如果数据在第一列，则只能向下和向右查找；
    //     // ②、如果数据在最后一列，则只能向左和向下查找；
    //     // ③、如果数据在中间位置，则可以向左、下、右三个方向进行数据的查找；
    //
    //     // 2、如果数据在最后一行
    //     // ①、如果数据在第一列，则只能向上和向右查找；
    //     // ②、如果数据在最后一列，则数据只能向上和向左进行查找；
    //     // ③、如果数据在中间位置，则数据可以向左、上、右三个方向进行查找；
    //
    //     // 3、如果数据在中间行
    //     // ①、如果数据在第一列，则只能向上、右、下三个方向进行查找；
    //     // ②、如果数据在最后一列，则数据只能向上、左、下三个方向进行查找；
    //     // ③、如果数据在中间位置，则数据可以向上、下、左、右四个方向进行查找；
    //
    //     // 配合广度优先策略进行即可
    // }
    //
    // public static boolean dfsFind(char[][] board, String word) {
    //     // 异常数据处理
    //     if (word == null || "".equals(word) || board == null) {
    //         return false;
    //     }
    //
    //     // 1、先将 word 拆分成 char 类型的数组
    //     char[] words = word.toCharArray();
    //     // 查看当前二维数组是否只有一行数据，如果只有一行数据，则相当于一维数组的左右遍历
    //     // 行
    //     int rows = board.length;
    //     // 列
    //     int columns = board[0].length;
    //     if (rows == 1) {
    //         // 相当于一维数组的遍历操作
    //         return arrHasWord(board[0], words);
    //     } else {
    //         for (int row = 0; row < rows; row++) {
    //             for (int col = 0; col < columns; col++) {
    //                 // 数据查找特征：
    //                 // 1、如果数据在第一行
    //                 // ①、如果数据在第一列，则只能向下和向右查找；
    //                 // ②、如果数据在最后一列，则只能向左和向下查找；
    //                 // ③、如果数据在中间位置，则可以向左、下、右三个方向进行数据的查找；
    //                 if (row == 0) {
    //                     if (col == 0) {
    //
    //                     } else if (col == columns - 1) {
    //
    //                     } else {
    //
    //                     }
    //                 }
    //
    //
    //                 // 2、如果数据在最后一行
    //                 // ①、如果数据在第一列，则只能向上和向右查找；
    //                 // ②、如果数据在最后一列，则数据只能向上和向左进行查找；
    //                 // ③、如果数据在中间位置，则数据可以向左、上、右三个方向进行查找；
    //                 if (row == rows - 1) {
    //                     if (col == 0) {
    //
    //                     } else if (col == columns - 1) {
    //
    //                     } else {
    //
    //                     }
    //                 }
    //
    //
    //                 // 3、如果数据在中间行
    //                 // ①、如果数据在第一列，则只能向上、右、下三个方向进行查找；
    //                 // ②、如果数据在最后一列，则数据只能向上、左、下三个方向进行查找；
    //                 // ③、如果数据在中间位置，则数据可以向上、下、左、右四个方向进行查找；
    //                 if (col == 0) {
    //
    //                 } else if (col == columns - 1) {
    //
    //                 } else {
    //
    //                 }
    //
    //
    //             }
    //         }
    //     }
    // }
    //
    // /**
    //  * <p> 在一维数组中查看是否存在某个单词，数据仅能向左向右遍历 </p>
    //  * @param board
    //  * @param words
    //  * @return
    //  */
    // public static boolean arrHasWord(char[] board, char[] words) {
    //     boolean ans = false;
    //
    //     // 1、找到所有在 board 中以 words 的起始字符的下标
    //     ArrayList<Integer> indexLists = new ArrayList<>();
    //     // 传入单词的第一个字符
    //     char firstCharForWords = words[0];
    //     // 遍历寻找
    //     for (int i = 0; i < board.length; i++) {
    //         if (board[i] == firstCharForWords) {
    //             indexLists.add(i);
    //         }
    //     }
    //
    //     // 如果就不存在对应的首字母，则直接返回
    //     if (indexLists.size() == 0) {
    //         return ans;
    //     } else {
    //         for (int item = 0; item < indexLists.size(); item++) {
    //             // 如果是向左判断，则只能始终向左；如果是向右判断，则只能始终向右；
    //             // 针对 board 的遍历
    //
    //             // 一个用于记录长度的参数
    //             int tmpLength = 0;
    //
    //             // 1、向左遍历
    //             for (int i = item; i >= 0; i--) {
    //                 // 针对 words 的遍历
    //                 for (int j = 0; j < words.length; j++) {
    //                     if (board[i] == words[j]) {
    //                         tmpLength++;
    //                     } else {
    //                         break;
    //                     }
    //                 }
    //             }
    //
    //             // 数据找到了
    //             if (tmpLength == words.length) {
    //                 ans = true;
    //                 return ans;
    //             } else {
    //                 // 重置长度
    //                 tmpLength = 0;
    //             }
    //
    //             // 2、向右遍历
    //             for (int i = item; i < board.length; i++) {
    //                 // 针对 words 的遍历
    //                 for (int j = 0; j < words.length; j++) {
    //                     if (board[i] == words[j]) {
    //                         tmpLength++;
    //                     } else {
    //                         break;
    //                     }
    //                 }
    //             }
    //
    //             // 数据找到了
    //             if (tmpLength == words.length) {
    //                 ans = true;
    //                 return ans;
    //             }
    //         }
    //
    //         return ans;
    //     }
    // }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * <p> 使用深度优先的方式进行遍历查找 </p>
     * @param board
     * @param word
     * @return
     */
    public static boolean dfsExist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        // 已经访问过的数据
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * <p> 递归方法 </p>
     * @param board 将被检查的二维数组
     * @param word 将要寻找的字符串
     * @param index 当前单词已经走到了的下标的位置
     * @param row 当前在 board 中正在检查的元素的行坐标
     * @param col 当前在 board 中正在检查的元素的纵坐标
     * @param visited 已经遍历过的 board 中的元素（如果遍历过，则赋值为 true，否则赋值为 false）
     * @return
     */
    private static boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited){
        // 1、如果索引已经到达了单词的末尾，说明单词已经找到了
        if (index == word.length()) {
            return true;
        }

        // 2、检查边界条件和是否已经访问过
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }

        // 3、检查当前单元格的字符是否与单词的当前字符匹配
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // 假设当前单元格是单词的一部分
        visited[row][col] = true;

        // 在四个方向上继续搜索
        for (int[] direction : DIRECTIONS) {
            if (dfs(board, word, index + 1, row + direction[0], col + direction[1], visited)) {
                return true;
            }
        }

        // 回溯，撤销当前单元格的访问状态
        visited[row][col] = false;

        return false;
    }

    /**
     * <p> 使用广度优先的方式进行遍历 </p>
     * @param board
     * @param word
     * @return
     */
    public static boolean bfsExist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (bfs(board, word, row, col, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * <p> 广度优先递归 </p>
     * @param board
     * @param word
     * @param startRow
     * @param startCol
     * @param visited
     * @return
     */
    private static boolean bfs(char[][] board, String word, int startRow, int startCol, boolean[][] visited) {
        // 用于层序遍历的queue结构
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ startRow, startCol, 0 });

        while (!queue.isEmpty()) {
            // 从 board 中开始进行广度优先遍历的起点
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int index = current[2];

            // 当前下标到了 word 的最后位置，说明找到了指定的单词
            if (index == word.length()) {
                return true;
            }

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                // 没有出现在无效的数据区域
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                        && !visited[newRow][newCol] && board[newRow][newCol] == word.charAt(index)) {
                    queue.offer(new int[] {newRow, newCol, index + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false;
    }

    /**
     * <p> 随机生成 char 类型的数组 </p>
     * @param maxRows
     * @param maxCols
     * @return
     */
    private static char[][] generateCharArr(int maxRows, int maxCols) {
        // 随机行和列的数量
        int rows = (int) (Math.random() * (maxRows + 1));
        int cols = (int) (Math.random() * (maxCols + 1));
        char[][] chars = new char[rows][cols];

        // 小写字母 a
        int aASCII = 'a';
        // 大写字母 A
        int A_ASCII = 'A';

        // 在 0-25 之间随机，然后再随机大写或者小写字母
        int wordsIndex;
        int upLowWord;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                wordsIndex = (int) (Math.random() * 26);
                upLowWord = (int) (Math.random() * 2);
                // 生成小写字母
                if (upLowWord < 1) {
                    chars[i][j] = (char) (aASCII + wordsIndex);
                }
                // 生成大写字母
                else {
                    chars[i][j] = (char) (A_ASCII + wordsIndex);
                }
            }
        }

        return chars;
    }

    /**
     * <p> 随机一个字符串(大小写字母) </p>
     * @param maxSize
     * @return
     */
    private static String generateRandomStr(int maxSize) {
        // 随机一个长度
        int charSize = (int) (Math.random() * maxSize + 1);
        // 小写字母 a
        int aASCII = 'a';
        // 大写字母 A
        int A_ASCII = 'A';
        int wordsIndex;
        int upLowWord;
        char[] chars = new char[charSize];
        for (int i = 0; i < charSize; i++) {
            wordsIndex = (int) (Math.random() * 26);
            upLowWord = (int) (Math.random() * 2);
            // 生成小写字母
            if (upLowWord < 1) {
                chars[i] = (char) (aASCII + wordsIndex);
            }
            // 生成大写字母
            else {
                chars[i] = (char) (A_ASCII + wordsIndex);
            }
        }
        return new String(chars);
    }

    /**
     * <p> 数组拷贝 </p>
     * @param arr
     * @return
     */
    public static char[][] copyArray(char[][] arr) {
        if (arr == null) {
            return null;
        }

        char[][] arrInner = new char[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrInner[i][j] = arr[i][j];
            }
        }
        return arrInner;
    }


    /**
     * <p> 数组打印 </p>
     * @param arr
     * @param <E>
     */
    public static void printArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(new String(arr[i]) + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 输入的数据
        char [][] board = new char[][] {
                {'H'}
        };
        // 要查找的字符串
        String findStr = "H";

        // DFS 搜索
        boolean ans0 = dfsExist(board, findStr);

        // BFS 搜索
        boolean ans1 = bfsExist(board, findStr);
        System.out.println(ans0);
        System.out.println(ans1);


        // int maxSize = 15;
        // // String str = generateRandomStr(maxSize);
        // // System.out.println(str);
        //
        // int maxRows = 10;
        // int maxCols = 10;
        //
        // int testTime = 500000;
        //
        // System.out.println("测试开始！");
        // for (int i = 0; i < testTime; i++) {
        //     // 随机char数组和字符串并拷贝数组
        //     char[][] arr = generateCharArr(maxRows, maxCols);
        //     String str = generateRandomStr(maxSize);
        //
        //     // DFS 搜索
        //     boolean dfsRes = dfsExist(arr, str);
        //     // BFS 搜索
        //     boolean bfsRes = bfsExist(arr, str);
        //     if (bfsRes != dfsRes) {
        //         System.out.println("出错了！");
        //         // 打印数组
        //         printArr(arr);
        //         // 输出字符串
        //         System.out.println(str);
        //         System.out.println("bfsRes: " +  bfsRes);
        //         System.out.println("dfsRes: " +  dfsRes);
        //         break;
        //     }
        // }
        // System.out.println("测试结束！");
    }
}
