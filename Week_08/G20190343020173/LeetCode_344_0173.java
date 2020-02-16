package org.crayzer.leetcode.editor.en.string;

public class LeetCode_344_ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int len = s.length;
            if (len == 0) return;

            int left = 0, right = len - 1;
            for (int i = 0, j = len - 1; i < j; i++, j--) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
    }
}
