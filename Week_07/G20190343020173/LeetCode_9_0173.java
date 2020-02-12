package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_9_PalindromeNumber {

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int reverseX = reverse(x);
            return x == reverseX;
        }

        private int reverse(int x) {
            int res = 0;
            while (x != 0) {
                int temp = x % 10;
                res = res * 10 + temp;
                x /= 10;
            }
            return res;
        }
    }
}
