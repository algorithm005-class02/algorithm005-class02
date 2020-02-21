package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_1143_LongestCommonSubsequence {

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

    class Solution1 {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] s1 = text1.toCharArray();
            char[] s2 = text2.toCharArray();
            int[][] dp = new int[s1.length + 1][s2.length + 1];

            for (int i = 1; i < s1.length + 1; i++) {
                for (int j = 1; j < s2.length + 1; j++) {
                    if (s1[i - 1] == s2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[s1.length][s2.length];
        }
    }
}
