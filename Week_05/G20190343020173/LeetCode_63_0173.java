package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_63_UniquePaths2 {

    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int width = obstacleGrid[0].length;
            int[] dp = new int[width];
            dp[0] = 1;
            for (int[] row : obstacleGrid) {
                for (int j = 0; j < width; j++) {
                    if (row[j] == 1)
                        dp[j] = 0;
                    else if (j > 0)
                        dp[j] += dp[j - 1];
                }
            }
            return dp[width - 1];
        }
    }

    class Solution1 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rows = obstacleGrid.length;
            int cols = obstacleGrid[0].length;

            if (obstacleGrid[0][0] == 1) return 0;
            obstacleGrid[0][0] = 1;

            for (int i = 1; i < rows; i++) {
                obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
            }

            for (int i = 1; i < cols; i++) {
                obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0;
            }

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    } else {
                        obstacleGrid[i][j] = 0;
                    }
                }
            }
            return obstacleGrid[rows - 1][cols - 1];
        }
    }
}
