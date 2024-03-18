package com.zmr.LearningFiles.OneWeekPlaning.Search.DFS;

/**
 * @Date 2024/3/4 21:26
 * @Description 岛屿数量
 * LeetCode 链接： https://leetcode.cn/problems/number-of-islands/description/
 **/
public class IslandNum {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 结果
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 外边的这两个循环确保了分开的岛屿也能被遍历到
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 当前是岛屿，且尚未被遍历过
                if (grid[row][col] == '1') {
                    ans++;
                    dfs(grid, row, col);
                }
            }
        }

        return ans;
    }

    /**
     * <p> 深度优先搜索方式 </p>
     *
     * @param grid            要操作的二维数组
     * @param row             行数
     * @param col             列数
     * @return
     */
    public static void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 检查边界条件
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        // 设置当前位置的元素为'0'，表示已经遍历
        grid[row][col] = '0';

        // 将与当前位置元素相邻的所有的 '1'，即连续的岛屿元素全部置为 '0'，避免出现问题
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // 数组不能越界
            if (newRow >= 0 && newRow <= rows && newCol >= 0 && newCol <= cols) {
                dfs(grid, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'O','X','O','O','O','O','O','O','O'},
                {'O','O','O','X','O','O','O','O','X'},
                {'O','X','O','X','O','O','O','O','X'},
                {'O','O','O','O','X','O','O','O','O'},
                {'X','O','O','O','O','O','O','O','X'},
                {'X','X','O','O','X','O','X','O','X'},
                {'O','O','O','X','O','O','O','O','O'},
                {'O','O','O','X','O','O','O','O','O'},
                {'O','O','O','O','O','X','X','O','O'}
        };

        System.out.println(numIslands(grid));
    }
}