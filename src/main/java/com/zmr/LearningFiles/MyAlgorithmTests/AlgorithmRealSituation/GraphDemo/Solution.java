package com.zmr.LearningFiles.MyAlgorithmTests.AlgorithmRealSituation.GraphDemo;

public class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
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

    private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        // 如果索引已经到达单词的末尾，说明单词已经找到
        if (index == word.length()) {
            return true;
        }

        // 检查边界条件和是否已经访问过
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }

        // 检查当前单元格的字符是否与单词的当前字符匹配
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
}

