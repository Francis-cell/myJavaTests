package com.zmr.LearningFiles.OneWeekPlaning.Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 单词查找 </p>
 * https://leetcode.cn/problems/word-search/
 */
public class SearchWords {
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    /** ------------------------广度优先搜索------------------------------ */
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (word == null) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 已访问的数组
        boolean[][] visited = new boolean[rows][cols];

        Queue<Node> queue = new LinkedList<>();
        // 找到 word 的首字母，然后在 board 中遍历，记录下来它们的坐标到队列中
        char tmpChar = word.charAt(0);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == tmpChar) {
                    // queue.offer(new Node(String.valueOf(tmpChar), row, col));
                    if (bfs(board, word, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board, String word, int startRow, int startCol) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(String.valueOf(word.charAt(0)), startRow, startCol));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int index = current.val.length();

            // 如果已拼接的串已经符合条件
            if (word.equals(String.valueOf(current.val))) {
                return true;
            }

            int tempRow = current.x;
            int tempCol = current.y;

            if (tempRow < 0 || tempRow >= rows || tempCol < 0 || tempCol >= cols
                    || !visited[tempRow][tempCol] || board[tempRow][tempCol] != word.charAt(current.val.length() - 1)) {
                continue;
            }

            // 将当前元素置为已访问
            visited[tempRow][tempCol] = true;

            for (int[] direction : DIRECTIONS) {
                int newRow = tempRow + direction[0];
                int newCol = tempCol + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    queue.offer(new Node(current.val + board[newRow][newCol], newRow, newCol));
                }
            }
        }

        return false;
    }

    static class Node {
        /** 已经拼接的串 */
        String val;
        /** 当前节点的横坐标 */
        int x;
        /** 当前节点的纵坐标 */
        int y;

        public Node(String val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }


    /** ------------------------深度优先搜索------------------------------ */
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
     */
    public static void printArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(new String(arr[i]) + ", ");
        }
        System.out.println();
    }


    public static boolean bfsExist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) { // 找到单词的第一个字母
                    if (bfs01(board, word, row, col)) {
                        return true; // 如果找到了完整的单词，返回 true
                    }
                }
            }
        }

        return false; // 没有找到完整的单词，返回 false
    }

    private static boolean bfs01(char[][] board, String word, int startRow, int startCol) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0}); // 存储行、列和当前单词字符的索引

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int index = current[2];

            if (index == word.length()) { // 当前位置的字符已经匹配完成，返回 true
                return true;
            }

            if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || board[row][col] != word.charAt(index)) {
                continue; // 如果当前位置不合法，或者已经访问过，或者当前字符不匹配，继续搜索下一个位置
            }

            visited[row][col] = true; // 标记当前位置为已访问

            // 将相邻的位置加入队列
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                queue.offer(new int[]{newRow, newCol, index + 1});
            }
        }

        return false; // 没有找到完整的单词，返回 false
    }

    public static void main(String[] args) {
        // char[][] board = {
        //         {'A', 'B', 'C', 'E'},
        //         {'S', 'F', 'C', 'S'},
        //         {'A', 'D', 'E', 'E'}
        // };
        char[][] board = {
                {'I','s'},
                {'s','w'},
                {'p','E'}
        };
        String word = "IswEps";
        // System.out.println(exist(board, word));
        // System.out.println(bfsExist(board, word));
        System.out.println(dfsExist(board, word));

        // int testTimes = 1000000;
        // int maxRows = 10;
        // int maxCols = 10;
        // int maxSize = 15;
        //
        // System.out.println("测试开始！");
        // for (int i = 0; i < testTimes; i++) {
        //     char[][] arr = generateCharArr(maxRows, maxCols);
        //     String str = generateRandomStr(maxSize);
        //
        //     // if (bfsExist(arr, str) != dfsExist(arr, str)) {
        //     if (exist(arr, str) != dfsExist(arr, str)) {
        //         System.out.println("出错了!");
        //         printArr(arr);
        //         System.out.println(str);
        //         break;
        //     }
        // }
        // System.out.println("测试结束！");
    }
}
