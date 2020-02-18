package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.HashMap;

public class LeetCode_91_DecodeWays {
    class Solution3 {
        public int numDecoding(String s) {
            int len = s.length();
            int end = 1;
            int cur = 0;
            if (s.charAt(len - 1) != '0') cur = 1;

            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    end = cur;//end 前移
                    cur = 0;
                    continue;
                }
                int ans1 = cur;
                int ans2 = 0;
                int ten = (s.charAt(i) - '0') * 10;
                int one = s.charAt(i + 1) - '0';
                if (ten + one <= 26) ans2 = end;
                end = cur;
                cur = ans1 + ans2;
            }
            return cur;
        }
    }

    class Solution2 {
        public int numDecodings(String s) {
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[len] = 1; //将递归法的结束条件初始化为 1
            //最后一个数字不等于 0 就初始化为 1
            if (s.charAt(len - 1) != '0') dp[len - 1] = 1;

            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') continue;
                int ans1 = dp[i + 1];
                int ans2 = 0;
                int ten = (s.charAt(i) - '0') * 10;
                int one = s.charAt(i + 1) - '0';
                if (ten + one <= 26) ans2 = dp[i + 2];
                dp[i] = ans1 + ans2;
            }
            return dp[0];
        }
    }

    class Solution1 {
        public int numDecodings(String s) {
            HashMap<Integer, Integer> map = new HashMap<>();
            return helper(s, 0, map);
        }

        private int helper(String s, int start, HashMap<Integer, Integer> map) {
            if (start == s.length()) return 1;
            if (s.charAt(start) == '0') return 0;
            int m = map.getOrDefault(start, -1);
            if (m != -1) return m;
            int ans1 = helper(s, start + 1, map);
            int ans2 = 0;

            if (start < s.length() - 1) {
                int ten = (s.charAt(start) - '0') * 10;
                int one = s.charAt(start + 1) - '0';
                if (ten + one <= 26) ans2 = helper(s, start + 2, map);
            }
            map.put(start, ans1 + ans2);
            return ans1 + ans2;
        }
    }

    class Solution {
        public int numDecodings(String s) {
            return helper(s, 0);
        }

        private int helper(String s, int start) {
            if (start == s.length()) return 1;
            if (s.charAt(start) == '0') return 0;

            int ans1 = helper(s, start + 1);
            int ans2 = 0;

            if (start < s.length() - 1) {
                int ten = (s.charAt(start) - '0') * 10;
                int one = s.charAt(start + 1) - '0';
                if (ten + one <= 26) ans2 = helper(s, start + 2);
            }
            return ans1 + ans2;
        }
    }
}
