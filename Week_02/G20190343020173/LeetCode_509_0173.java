package org.crayzer.leetcode.editor.en.treez_recursion;

public class LeetCode_509_FibonacciNumber {

    /**
     * T: O(n)
     * S: O(1)
     */
    class Solution2 {
        public int fib(int N) {
            int curr = 0, next = 1;
            while (N-- > 0) {
                next = curr + next;
                curr = next - curr;
            }

            return curr;
        }
    }

    /**
     * T: O(n)
     * S: O(n)
     */
    class Solution1 {
        public int fib(int N) {
            if (N == 0) return 0;
            if (N == 1) return 1;

            int[] arr = new int[N+1];
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i <= N; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
            }

            return arr[N];
        }
    }

    /**
     * 不推荐
     * O(2^n)
     */
    class Solution {
        public int fib(int N) {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return fib(N - 2) + fib(N - 1);
        }
    }
}
