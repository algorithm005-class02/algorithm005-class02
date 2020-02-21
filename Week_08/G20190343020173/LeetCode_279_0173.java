package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_279_PerfectSquares {

    class Solution1 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n ; i++) {
                dp[i] = i;
                for (int j = 1; i - j * j >= 0 ; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }

    }

    class Solution {
        int[] memo;
        public int numSquares(int n) {
            memo = new int[n + 1];
            return helper(n);
        }

        private int helper(int n) {
            if (memo[n] != 0) return memo[n];
            int val = (int) Math.sqrt(n);
            if (val * val == n) return memo[n] = 1;

            int res = Integer.MAX_VALUE;
            for (int i = 1; i * i < n; i++) {
                res = Math.min(res, helper(n - i * i) + 1);
            }

            return memo[n] = res;
        }
    }
}
