package org.crayzer.leetcode.editor.en.string;

public class LeetCode_680_ValidPalindrome2 {

    class Solution1 {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0, j = chars.length - 1;
            while (i < j && chars[i] == chars[j]) {
                i++;
                j--;
            }
            return isPalindrome(chars, i, j - 1) || isPalindrome(chars, i + 1, j);
        }

        private boolean isPalindrome(char[] chars, int start, int end) {
            while (start < end) {
                if (chars[start++] != chars[end--]) return false;
            }
            return true;
        }
    }

    class Solution {
        public boolean validPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
                }
            }
            return true;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) return false;
            }
            return true;
        }
    }
}
