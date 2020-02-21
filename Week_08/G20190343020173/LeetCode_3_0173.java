package org.crayzer.leetcode.editor.en.string;

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0, res = 0;
            int[] map = new int[128];
            while (right < s.length()) {
                char c1 = s.charAt(right);
                map[c1]++;
                right++;

                while (map[c1] > 1) {
                    char c2 = s.charAt(left);
                    map[c2]--;
                    left++;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
