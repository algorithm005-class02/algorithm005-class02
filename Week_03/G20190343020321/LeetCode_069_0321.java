/**
 * x 的平方根
 * 舍去小数部分
 *
 * @author WindBruce
 */
public class LeetCode_069_0321 {

    public static void main(String[] args) {
        int result = new Solution().mySqrt(11);
        System.out.println(result);
    }

    static class Solution {

        /**
         * x 的平方根
         * 二分法
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            //设置左边界 ：0
            long left = 0;
            // 设置右边界： x / 2 + 1
            long right = x / 2 + 1;
            while (left < right) {
                // 取右中位数
                long mid = (left + right + 1) >>> 1;
                long square = mid * mid;
                if (square > x) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return (int) left;
        }

        /**
         * x 的平方根
         * 牛顿迭代法
         *
         * @param x
         * @return
         */
        public int mySqrt_1(int x) {
            long t = x;
            while (t * t > x) {
                t = (t + x / t) / 2;
            }
            return (int) t;
        }
    }


}
