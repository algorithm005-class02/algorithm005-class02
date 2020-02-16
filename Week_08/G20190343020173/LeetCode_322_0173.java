package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.Arrays;

public class LeetCode_322_CoinChange {

    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, -2);
            return helper(coins, amount, memo);
        }

        private int helper(int[] coins, int amount, int[] memo) {
            if (amount == 0) return 0;
            if (memo[amount] != -2) return memo[amount];
            int ans = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin < 0) continue;
                int res = helper(coins, amount - coin, memo);
                if (res == -1) continue;
                ans = Math.min(ans, res + 1);
            }
            memo[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
            return memo[amount];
        }
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int ans = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin < 0) continue;
                int res = coinChange(coins, amount - coin);
                if (res == -1) continue;
                ans = Math.min(ans, res + 1);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
