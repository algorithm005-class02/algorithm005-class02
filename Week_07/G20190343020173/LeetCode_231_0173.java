package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_231_PowerOfTwo {

    class Solution1 {
        public boolean isPowerOfTwo(int n) {
            // return n != 0 && (n & n - 1) == 0;

            if (n == 0) return false;
            long x = (long) n;
            return (x & (x - 1)) == 0;
        }
    }

    class Solution {
        public boolean isPowerOfTwo(int n) {
            // return n != 0 && (n & n - 1) == 0;

            if (n == 0) return false;
            long x = (long) n;
            return (x & (-x)) == x;
        }
    }
}
