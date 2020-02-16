package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_221_MaximalSquare {
    class Solution1 {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
            int height = matrix.length;
            int width = matrix[0].length;

            int[] dp = new int[width + 1];
            int maxSide = 0, prev = 0;
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    int temp = dp[j];
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                        maxSide = Math.max(maxSide, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                    prev = temp;
                }
            }
            return maxSide * maxSide;
        }
    }


    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
            int height = matrix.length;
            int width = matrix[0].length;
            int maxSide = 0;

            int[][] dp = new int[height + 1][width + 1];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                        maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }
}
