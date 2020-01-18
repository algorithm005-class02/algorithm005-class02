/**
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
 */

class Solution {
    // 方法一: 暴力解法 (O(n))
    public double myPow_1(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x  = 1/x;
            n = -n;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result*x;
        }
        return result;
    }

    // 方法二: 递归 (O(logn))
    public double myPow_2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }
    public double fastPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
