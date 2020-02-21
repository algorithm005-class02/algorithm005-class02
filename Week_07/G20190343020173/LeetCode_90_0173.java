package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_90_ReverseBits {

    public class Solution1 {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res += n & 1;
                n >>= 1;
            }
            return res;
        }
    }
}
