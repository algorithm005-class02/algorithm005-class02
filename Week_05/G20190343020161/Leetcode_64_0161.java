package com.company;

public class Solution_64 {
    public int minPathSum(int[][] grid) {
        //第一个版本
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int row = grid.length;
//        int col = grid[0].length;
//        int[][] a = new int[row][col];
//        a[0][0] = grid[0][0];
//
//        int res = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (i == 0 && j != 0) {
//                    a[i][j] = a[i][j - 1] + grid[i][j];
//                } else if (i != 0 && j == 0) {
//                    a[i][j] = a[i - 1][j] + grid[i][j];
//                } else if (i != 0 && j != 0) {
//                    a[i][j] = Math.min(a[i - 1][j], a[i][j - 1]) + grid[i][j];
//                }
//            }
//        }
//        return a[row - 1][col - 1];

        //简化后
        // DP方程 a[i][j] = Math.min(a[i - 1][j], a[i][j - 1]) + grid[i][j]
        // 时间复杂度O(n^2)
        // 空间复杂度O(1)
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else if (i != 0 && j != 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
