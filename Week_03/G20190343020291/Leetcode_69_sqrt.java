/**
 * x 的平方根
 * https://leetcode.com/problems/sqrtx/
 */
public class Leetcode_69_sqrt {
    /**
     * 方法1：二分查找
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1, right = x / 2;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (mid > x / mid) { // 这里不要用乘法，会整型溢出
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * 方法2：牛顿迭代法
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        long cur = x;
        while (cur > x / cur) {
            cur = (cur + x / cur) / 2; // 这里也会溢出，使用long
        }
        return (int)cur;
    }
    // bad cases: 2147483647 -> 46340
}
