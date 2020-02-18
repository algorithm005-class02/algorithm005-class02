package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_115_DistinctSubsequences {

    class Solution5 {
        public int numDistinct(String s, String t) {
            int s_len = s.length();
            int t_len = t.length();
            int[] dp = new int[s_len + 1];
            for (int i = 0; i <= s_len; i++) {
                dp[i] = 1;
            }
            for (int t_i = 1; t_i <= t_len; t_i++) {
                int pre = dp[0];
                dp[0] = 0;
                for (int s_i = 1; s_i <= s_len; s_i++) {
                    int temp = dp[s_i];
                    if (t.charAt(t_i - 1) == s.charAt(s_i - 1)) {
                        dp[s_i] = dp[s_i - 1] + pre;
                    } else {
                        dp[s_i] = dp[s_i - 1];
                    }
                    pre = temp;
                }
            }
            return dp[s_len];
        }
    }

    class Solution4 {
        public int numDistinct(String s, String t) {
            int s_len = s.length();
            int t_len = t.length();
            int[][] dp = new int[s_len + 1][t_len + 1];
            for (int i = 0; i <= s_len; i++) {
                dp[i][t_len] = 1;
            }

            for (int t_i = t_len - 1; t_i >= 0; t_i--) {
                dp[s_len][t_i] = 0; // 这句可以省去，因为默认值是 0
                //倒着进行，S 每次增加一个字母
                for (int s_i = s_len - 1; s_i >= 0; s_i--) {
                    //如果当前字母相等
                    if (t.charAt(t_i) == s.charAt(s_i)) {
                        //对应于两种情况，选择当前字母和不选择当前字母
                        dp[s_i][t_i] = dp[s_i + 1][t_i + 1] + dp[s_i + 1][t_i];
                        //如果当前字母不相等
                    } else {
                        dp[s_i][t_i] = dp[s_i + 1][t_i];
                    }
                }
            }
            return dp[0][0];
        }
    }

    class Solution3 {
        private int count = 0;
        private Map<String, Integer> map;

        public int numDistinct(String s, String t) {
            this.map = new HashMap<>();
            helper(s, 0, t, 0);
            return count;
        }

        private void helper(String s, int sStart, String t, int tStart) {
            if (tStart == t.length()) {
                count++;
                return;
            }
            if (sStart == s.length()) return;
            String key = sStart + "@" + tStart;
            if (map.containsKey(key)) {
                count += map.get(key);
                return;
            }
            int count_pre = count;
            if (s.charAt(sStart) == t.charAt(tStart)) {
                helper(s, sStart + 1, t, tStart + 1);
            }
            helper(s, sStart + 1, t, tStart);
            int count_increment = count - count_pre;
            map.put(key, count_increment);
        }
    }

    class Solution1 {
        private Map<String, Integer> map;

        public int numDistinct(String s, String t) {
            this.map = new HashMap<>();
            return helper(s, 0, t, 0);
        }

        private int helper(String s, int sStart, String t, int tStart) {
            if (tStart == t.length()) return 1;
            if (sStart == s.length()) return 0;
            int count = 0;
            String key = sStart + "@" + tStart;
            if (map.containsKey(key)) return map.get(key);

            if (s.charAt(sStart) == t.charAt(tStart)) {
                count = helper(s, sStart + 1, t, tStart + 1)
                        + helper(s, sStart + 1, t, tStart);
            } else {
                count = helper(s, sStart + 1, t, tStart);
            }
            map.put(key, count);
            return count;
        }
    }

    class Solution {
        public int numDistinct(String s, String t) {
            return helper(s, 0, t, 0);
        }

        private int helper(String s, int s_start, String t, int t_start) {
            if (t_start == t.length()) return 1;
            if (s_start == s.length()) return 0;
            int count = 0;

            if (s.charAt(s_start) == t.charAt(t_start)) {
                count = helper(s, s_start + 1, t, t_start + 1)
                        + helper(s, s_start + 1, t, t_start);
            } else {
                count = helper(s, s_start + 1, t, t_start);
            }
            return count;
        }
    }
}
