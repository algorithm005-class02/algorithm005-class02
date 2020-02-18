package org.crayzer.leetcode.editor.en.string;

public class LeetCode_557_ReverseWordsInAString3 {

    class Solution1 {
        public String reverseWords(String s) {
            char[] chs = s.toCharArray();
            int len = s.length();
            int start = 0, end = 0;
            while (end < len) {
                int num = s.indexOf(" ", start);
                end = num;
                if (num < 0) {
                    end = len;
                }
                reverse(chs, start, end - 1);
                start = end + 1;
                if (num < 0) {
                    break;
                }
            }
            return new String(chs);
        }

        private void reverse(char[] chars, int i, int j) {
            while (i < j) {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
    }

    class Solution {
        public String reverseWords(String s) {
            String words[] = s.split(" ");
            StringBuilder res = new StringBuilder();
            for (String word : words)
                res.append(new StringBuilder(word).reverse().toString() + " ");
            return res.toString().trim();
        }
    }
}
