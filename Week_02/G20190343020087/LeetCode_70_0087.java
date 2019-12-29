import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n<3) return n;
        int res = 0;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
            res = array[i];
        }
        return res;
    }
}
// @lc code=end

