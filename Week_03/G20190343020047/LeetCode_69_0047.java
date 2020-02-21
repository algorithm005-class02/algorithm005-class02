class Solution {
    public int mySqrt(int x) {
        // 0.暴力求解
        // return (int)Math.sqrt(x);
        // 1.二分查找
        // if (x == 0) {
        //     return 0;
        // }
        // long left = 1;
        // long right = x / 2;

        // while (left < right) {
        //     long mid = (right + left +1) >>> 1;
        //     if (mid * mid > x) {
        //         right = mid - 1;
        //     }else {
        //         left = mid;
        //     }
        // }
        // return (int)left;
        //2.牛顿迭代法
        long res = x;
        while (res * res > x) {
            res = (res + x / res) >>> 1;
        }
        return (int)res;
    }
}