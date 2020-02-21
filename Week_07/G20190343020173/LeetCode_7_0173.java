package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_7_ReverseInteger {
    class Solution {
        public int reverse(int x) {
            int of = ((1 << 31) - 1) / 10;
            int res = 0;
            while (x != 0) {
                if (Math.abs(res) > of) return 0;
                int temp = x % 10;
                res = res * 10 + temp;
                x /= 10;
            }
            return res;
        }
    }
}
