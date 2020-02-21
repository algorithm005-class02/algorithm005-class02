package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_188_BestTimeToBuyAndSellStock4 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (n == 0) return 0;
            if (k > n / 2)
                return maxProfit_k_inf(prices);
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int max_k = k; max_k >= 1; max_k--) {
                    if (i - 1 == -1) {
                        /* 处理 base case */
                        dp[i][max_k][0] = 0;
                        dp[i][max_k][1] = -prices[i];
                        continue;
                    }
                    dp[i][max_k][0] = Math.max(dp[i-1][max_k][0], dp[i-1][max_k][1] + prices[i]);
                    dp[i][max_k][1] = Math.max(dp[i-1][max_k][1], dp[i-1][max_k-1][0] - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }

        private int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }
}
