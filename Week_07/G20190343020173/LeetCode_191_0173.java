package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_191_NumberOf1Bits {

    public class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                 n = n & n - 1;
            }
            return count;
        }
    }

    class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & mask) != 0) {
                    bits++;
                }
                mask <<= 1;
            }
            return bits;
        }
    }
}
