package org.crayzer.leetcode.editor.en.string;

public class LeetCode_151_ReverseWordsInAString {

    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            if (s.equals("")) return "";
            String[] strs = s.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = strs.length - 1; i >= 0; i--) {
                if (strs[i].equals(" ")) continue;
                builder.append(strs[i]);
                builder.append(" ");
            }
            return builder.toString().substring(0, builder.length() - 1);
        }
    }
}
