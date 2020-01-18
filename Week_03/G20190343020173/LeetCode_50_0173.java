package org.crayzer.leetcode.editor.en.分治_回溯;

public class LeetCode_50_PowN_X {
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            if (n < 0) {
                x = 1.0 / x;
                N = -N;
            }
            return fastPow(x, N);
        }

        private double fastPow (double x, long n) {
            if (n == 0) return 1.0;
            if (n == 1) return x;
            double half = fastPow(x, n / 2);
            return n % 2 == 1 ? half * half * x : half * half;
        }
    }
}
