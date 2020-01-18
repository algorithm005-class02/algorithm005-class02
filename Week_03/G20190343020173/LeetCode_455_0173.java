package org.crayzer.leetcode.editor.en.greedy;

import java.util.Arrays;

public class LeetCode_455_AssignCookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g == null || s == null) return 0;
            Arrays.sort(g);
            Arrays.sort(s);
            int gi = 0, si = 0;
            while (gi < g.length && si < s.length) {
                if (g[gi] <= s[si]) gi++;
                si++;
            }
            return gi;
        }
    }
}
