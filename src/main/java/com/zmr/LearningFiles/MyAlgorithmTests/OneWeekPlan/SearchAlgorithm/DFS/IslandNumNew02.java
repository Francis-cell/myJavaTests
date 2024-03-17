package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlan.SearchAlgorithm.DFS;

/**
 * @Author franciszmr
 * @Date 2024/3/4 22:37
 * @Version 1.0
 * @Description TODO
 **/
public class IslandNumNew02 {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 用来记录已经遍历过的元素的下标
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    ans++;
                    dfs(grid, visited, row, col);
                }
            }
        }

        return ans;
    }

    public static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true; // 标记当前位置已经遍历过

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // 边界检查
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
