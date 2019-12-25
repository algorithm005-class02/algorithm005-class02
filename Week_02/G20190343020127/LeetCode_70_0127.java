/**
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

链接：https://leetcode-cn.com/problems/climbing-stairs
*/


class Solution {

    /**
     * 方法一：暴力法
     * 时间复杂度：O(2^n)。
     * f(i,n) = f(i + 1,n) + f(i + 2,n)
     * 其中 i 定义了当前阶数，而 n 定义了目标阶数。
     */
    public int climbStairs_1(int n) {
        return recur(0, n);
    }
    public int recur(int i,int n) {
        if (i > n) return 0;
        if (i == n) return 1;
        return recur(i + 1, n) + recur(i + 2, n);
    }

    /**
     * 方法一：动态规划
     * 时间复杂度：O(n)。
     * dp[i] = dp[i−1] + dp[i−2]
     */
    public int climbStairs_2(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}


