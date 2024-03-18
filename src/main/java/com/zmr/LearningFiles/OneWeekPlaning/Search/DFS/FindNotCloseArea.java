package com.zmr.LearningFiles.OneWeekPlaning.Search.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author franciszmr
 * @Date 2024/3/7 21:54
 * @Version 1.0
 * @Description https://leetcode.cn/problems/surrounded-regions/description/
 **/
public class FindNotCloseArea {
    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    // 此处每次递归前需要进行重置
                    // 用来记录当前正在搜索的“岛屿”，如果在递归过程中发现“岛屿”中有一个元素的相邻元素越界，那么这些被标记的元素就无需被调整成 'X'
                    // 反之，全部调整成 'X'
                    List<Map<String, Integer>> notMarked = new ArrayList<>();
                    boolean tmpAns = dfs(board, row, col, visited, notMarked);
                    // 如果临时返回值为 false，那么认为这组被包围了，全部标记为
                    if (!tmpAns) {
                        for (int i = 0; i < notMarked.size(); i++) {
                            Map<String, Integer> tmpMap = notMarked.get(i);
                            board[tmpMap.get("row")][tmpMap.get("col")] = 'X';
                        }
                    }
                }
            }
        }
    }

    private static boolean dfs(char[][] board, int row, int col, boolean[][] visited, List<Map<String, Integer>> notMarked) {
        int rows = board.length;
        int cols = board[0].length;

        boolean ans = false;

        // 临界条件(如果当前元素越界，则返回 true，代表本组元素无需被标记为 'X')
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            ans = true;
        }

        visited[row][col] = true;

        if (board[row][col] == 'X') {
            return false;
        }

        // 记录下来当前的元素位置到 notMarked 临时数组中
        Map<String, Integer> tmpMap = new HashMap<>();
        tmpMap.put("row", row);
        tmpMap.put("col", col);
        notMarked.add(tmpMap);

        // 遍历当前元素的四个边界，如果有一个元素越界，那么就将当前元素所在的“岛屿”分组保留，无需标记为'X'
        for (int[] direction : DIRECTION) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // 如果发现越界，则直接返回 true 即可
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return true;
            }
            if (!visited[newRow][newCol]) {
                ans = ans || dfs(board, newRow, newCol, visited, notMarked);
            }
        }

        return ans;
    }

    private static void printArray(char[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
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
        solve(board);
        printArray(board);
    }
}
