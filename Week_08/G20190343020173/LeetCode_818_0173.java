package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.Arrays;

public class LeetCode_818_RaceCar {

    class Solution1 {
        public int racecar(int target) {
            int[] dp = new int[target + 1];
            for (int i = 1;i <= target; i++){
                dp[i] = Integer.MAX_VALUE;
                for (int forword = 1;(1 << forword) - 1 < 2 * i; forword++) {
                    int j = (1 << forword) - 1;
                    if(j == i)
                        dp[i] = forword;
                    else if (j > i)
                        dp[i] = Math.min(dp[i], forword + 1 + dp[j - i]);
                    else
                        for(int back = 0; back < forword; back++) {
                            int k = (1 << back) - 1;
                            dp[i] =Math.min(dp[i], forword + 1 + back + 1 + dp[i - j + k]);
                        }
                }
            }
            return dp[target];
        }
    }

    class Solution {
        public int racecar(int target) {
            int[] dp = new int[target + 3];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0; dp[1] = 1; dp[2] = 4;

            for (int t = 3; t <= target; ++t) {
                int k = 32 - Integer.numberOfLeadingZeros(t);
                if (t == (1<<k) - 1) {
                    dp[t] = k;
                    continue;
                }
                for (int j = 0; j < k-1; ++j)
                    dp[t] = Math.min(dp[t], dp[t - (1<<(k-1)) + (1<<j)] + k-1 + j + 2);
                if ((1<<k) - 1 - t < t)
                    dp[t] = Math.min(dp[t], dp[(1<<k) - 1 - t] + k + 1);
            }

            return dp[target];
        }
    }
}
