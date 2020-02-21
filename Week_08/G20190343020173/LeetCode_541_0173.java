package org.crayzer.leetcode.editor.en.string;

public class LeetCode_541_ReverseString2 {
    class Solution {
        public String reverseStr(String s, int k) {
            int kk = 2 * k;
            int n = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i += kk) {
                if (i + kk < n) reverse(chars, i, i + k - 1);
                else if (i + k < n) reverse(chars, i, i + k - 1);
                else reverse(chars, i, n - 1);
            }
            return new String(chars);
        }

        private void reverse(char[] chars, int begin, int end) {
            while (begin < end) {
                char tmp = chars[begin];
                chars[begin++] = chars[end];
                chars[end--] = tmp;
            }
        }
    }
}
