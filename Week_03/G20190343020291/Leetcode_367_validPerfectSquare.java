/**
 * 有效的完全平方数
 */
public class Leetcode_367_validPerfectSquare {

    /**
     * 方法1： 二分查找
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        int left = 1, right = num / 2;
        while (left <= right) {
            long mid = (left + right + 1) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = (int)mid - 1;
            } else {
                left = (int)mid + 1;
            }
        }
        return false;
    }

    /**
     * 方法2： 牛顿迭代法
     */
    public boolean isPerfectSquare2(int num) {
        long cur = num;
        while (cur * cur > num) {
            cur = (cur + num / cur) / 2;
        }

        return cur * cur == num;
    }



}
