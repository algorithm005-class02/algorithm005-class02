package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.Arrays;

public class LeetCode_62_UniquePaths {
    // 时间复杂度：O(m*n)
    // 空间复杂度：O(n)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    cur[j] = cur[j - 1];
                }
            }
            return cur[n - 1];
        }
    }

    // 时间复杂度：O(m*n)
    // 空间复杂度：O(2n)
    class Solution2 {
        public int uniquePaths(int m, int n) {
            int[] pre = new int[n];
            int[] cur = new int[n];
            Arrays.fill(pre, 1);
            Arrays.fill(cur, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    cur[j] = cur[j - 1] + pre[j];
                }
                pre = cur.clone();
            }
            return pre[n - 1];
        }
    }

    // 时间复杂度：O(m*n)
    // 空间复杂度：O(m*n)
    class Solution1 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) dp[i][0] = 1;
            for (int j = 0; j < n; j++) dp[0][j] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
