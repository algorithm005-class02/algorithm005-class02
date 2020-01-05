/**
 * x的n次方
 * https://leetcode.com/problems/powx-n/
 */
public class Leetcode_50_powxn {
    /**
     * 分治法求解
     */
    public double myPow(double x, int n) {
        long nn = n;
        //  -2^31 <= n <= 2^31 - 1
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }
        return helper(x, nn);
    }

    private double helper(double x, long n) {
        // 递归终止条件
        if (n == 0) {
            return 1.0;
        }

        // 下沉一层处理
        double res = helper(x, n / 2);

        // 子问题结果合并
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
}
