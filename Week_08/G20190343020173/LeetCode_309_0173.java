package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_309_BestTimeToBuyAndSellStockWithCooldown {
    class Solution {
        /**
         * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
         * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
         */
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 0) return 0;

            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            int dp_pre_0 = 0;

            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
                dp_pre_0 = temp;
            }
            return dp_i_0;
        }
    }
}
