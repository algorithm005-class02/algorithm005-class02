package org.crayzer.leetcode.editor.en.string;

public class LeetCode_5_LongestPalindromicSubstring {

    class Solution1 {
        public String longestPalindrome(String s) {
            int n = s.length() - 1;
            String res = "";
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j--) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 < 2 || dp[i+ 1][j - 1]);

                    if (dp[i][j] && j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;
        }
    }

    class Solution {
        private int lo, maxLen;
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) return s;
            for (int i = 0; i < len - 1; i++) {
                extendPalindrome(s, i, i);
                extendPalindrome(s, i, i + 1);
            }
            return s.substring(lo, lo + maxLen);
        }

        private void extendPalindrome(String s, int j, int k) {
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            while (maxLen < k - j - 1) {
                lo = j + 1;
                maxLen = k - j - 1;
            }
        }
    }
}
