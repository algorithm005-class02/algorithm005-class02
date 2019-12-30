/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * @author WindBruce
 */
public class LeetCode_050_0321 {

    public static void main(String[] args) {
        double result = new Solution().myPow_1(3, 4);
        System.out.println(result);
    }

    static class Solution {

        /**
         * 蛮力
         * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            for (long i = 0; i < N; i++) {
                ans = ans * x;
            }
            return ans;
        }

        /**
         * 二分法
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow_1(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == -1) {
                return 1 / x;
            }
            double half = myPow(x, n / 2);
            double rest = myPow(x, n % 2);
            return rest * half * half;
        }

    }


}
