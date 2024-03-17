package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlan.SearchAlgorithm.DFS;

/**
 * @Author franciszmr
 * @Date 2024/3/4 22:25
 * @Version 1.0
 * @Description TODO
 **/
public class IslandNumNew01 {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    ans++;
                    dfs(grid, row, col);
                }
            }
        }

        return ans;
    }

    public static void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // 标记当前位置已经遍历过

        for (int[] direction : DIRECTIONS) {
            dfs(grid, row + direction[0], col + direction[1]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
