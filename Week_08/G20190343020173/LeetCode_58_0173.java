package org.crayzer.leetcode.editor.en.string;

public class LeetCode_58_LengthOfLastWord {
    class Solution1 {
        public int lengthOfLastWord(String s) {
            int end = s.length() - 1;
            while (end >= 0 && s.charAt(end) == ' ') end--;
            if (end < 0) return 0;
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            return end - start;
        }
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            String[] strs = s.split(" +");
            if (strs.length == 0) return 0;
            return strs[strs.length - 1].length();
        }
    }
}
