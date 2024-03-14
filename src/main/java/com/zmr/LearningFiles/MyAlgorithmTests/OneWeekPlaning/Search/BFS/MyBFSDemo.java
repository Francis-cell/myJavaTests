package com.zmr.LearningFiles.MyAlgorithmTests.OneWeekPlaning.Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 在一个二维数组中查看是否存在某个值 </p>
 */
public class MyBFSDemo {
    public final static int[][] DIRECTIONS = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    /**
     * 搜索算法 bfs
     * @param grid
     * @param target
     * @return
     */
    public static boolean bfs(int[][] grid, int target) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        // 将起始位置加入队列
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            // 取出当前位置的元素
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (grid[row][col] == target) {
                return true;
            }

            // 标记当前位置为已访问
            visited[row][col] = true;

            // 将相邻位置的元素加入到 queue 中
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = 5;
        boolean found = bfs(grid, target);
        System.out.println("Target " + (found ? "found!" : "not found!"));
    }
}
