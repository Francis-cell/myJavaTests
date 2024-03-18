package com.zmr.LearningFiles.OneWeekPlaning.Search.DFS;

/**
 * @Date 2024/3/7 21:08
 * @Version 1.0
 * @Description https://leetcode.cn/problems/max-area-of-island/description/
 **/
public class MaxIslandArea {
    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 值为1，并且没有被遍历过
                if (grid[row][col] == 1) {
                    int currentArea = dfs(grid, row, col);
                    if (currentArea > ans) {
                        ans = currentArea;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * <p> 广度优先遍历问题求解 </p>
     */
    private static int dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 检查边界条件
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        // 设置当前位置的元素值为 0
        grid[row][col] = 0;
        // 设置当前的岛屿面积为 1
        int area = 1;

        // 遍历上下左右
        for (int[] direction : DIRECTION) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            area += dfs(grid, newRow, newCol);
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
