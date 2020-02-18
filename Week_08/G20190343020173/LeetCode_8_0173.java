package org.crayzer.leetcode.editor.en.string;

public class LeetCode_8_StringToInteger {

    class Solution {
        public int myAtoi(String str) {
            int index = 0, sign = 1, total = 0;
            // empty string
            if (str == null || str.length() == 0) return 0;
            // remove spaces
            while (index < str.length() && str.charAt(index) == ' ') index++;
            if (index == str.length()) return 0;
            // handle sign
            if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                sign = str.charAt(index) == '+' ? 1 : -1;
                index++;
            }

            while (index < str.length()) {
                int digit = str.charAt(index) - '0';
                if (digit < 0 || digit > 9) break;
                if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                    total = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                total = 10 * total + digit;
                index++;
            }
            return total * sign;
        }
    }
}
