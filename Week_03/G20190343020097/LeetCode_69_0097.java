package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2019/12/29 10:17
 *  * @description
 *  
 */
public class LeetCode_69_0097 {

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long left = 1, right = x;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left * left > x ? (int) left - 1 : (int) left;
    }

    /**
     * 牛顿
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
}
