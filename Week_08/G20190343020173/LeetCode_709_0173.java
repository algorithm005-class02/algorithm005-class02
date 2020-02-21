package org.crayzer.leetcode.editor.en.string;

public class LeetCode_709_ToLowerCase {
    class Solution1 {
        public String toLowerCase(String str) {
            return str.toLowerCase();
        }
    }

    class Solution {
        public String toLowerCase(String str) {
            if (str == null || str.length() == 0) return str;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                builder.append(doToLowerCase(str.charAt(i)));
            }
            return builder.toString();
        }

        private char doToLowerCase(char c) {
            if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
            return c;
        }
    }
}
