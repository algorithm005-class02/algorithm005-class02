/**
 * Fibonacci数
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Leetcode_509_fibonacciNumber {
    /**
     * 方法1："傻"递归
     */
    public int fib(int N) {
        return N <= 1 ? N : fib(N - 1) + fib(N - 2);
    }

    /**
     * 方法2：记忆化搜索
     */
    public int fib2(int N) {
        return helper(N, new int[N + 1]);
    }

    private int helper(int N, int[] memo) {
        if (N <= 1) {
            return N;
        }

        if (memo[N] == 0) {
            memo[N] = helper(N - 1, memo) + helper(N - 2, memo);
        }

        return memo[N];
    }
    /**
     * 方法3: Bottom Up （自底向上）
     */
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }

        int f0 = 0, f1 = 1, f2 = 1;
        for (int i = 2; i <= N; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
