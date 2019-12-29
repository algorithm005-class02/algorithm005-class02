package leetcode;

import remoteinvoke.HackSystem;

/**
 * * @author jiangli
 * * @date 2019/12/25 9:23
 * * @description powx-n
 */
public class LeetCode_50_0097 {

    public static void main(String[] args) {
        LeetCode_50_0097 l = new LeetCode_50_0097();
        double v = l.myPow2(2.0, 10);
        System.out.println(v);
    }

    /**
     * 暴力解法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        int m = n < 0 ? -n : n;
        double sum = x;
        for (int i = 0; i < m - 1; i++) {
            sum = sum * x;
        }
        if (n < 0) {
            return 1 / sum;
        } else {
            return sum;
        }
    }

    /**
     * stackoverflow
     *
     * @param x
     * @param n
     * @return
     */
    public double fastPow(double x, int n) {
        if (n == 1) return x;
        int m;
        if (n % 2 == 0) {
            m = n / 2;
        } else {
            m = (n - 1) / 2;
        }
        double half = fastPow(x, m);
        if (n % 2 == 1) {
            half = half * half * x;
        } else {
            half = half * half;
        }
        return half;
    }

    /**
     * 递归
     * 1.recursion terminator
     * 2.process data in current level
     * 3.drill down
     * 5.revert state
     */
    /**
     * 回溯
     * 1.recursion terminator
     * 2.process data in current level (split problem)
     * 3.drill down (process subproblems)
     * 4.merge subresults
     * 5.revert state
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }

    public double myPow3(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        long m = n;
        if (n < 0) {
            m = -n;
            x = 1 / x;
        }
        return fastPow3(x, m);
    }

    /**
     * 官方解答 快速幂算递归
     *
     * @param x
     * @param n
     * @return
     */
    public double fastPow3(double x, long n) {
        if (n == 0) return 1;
        double half = fastPow3(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow4(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        long m = n;
        if (n < 0) {
            m = -n;
            x = 1 / x;
        }
        double ans = 1;
        double account = x;
        for (long i = m; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                ans = ans * account;
            }
            account = account * account;
        }
        return ans;
    }

}
