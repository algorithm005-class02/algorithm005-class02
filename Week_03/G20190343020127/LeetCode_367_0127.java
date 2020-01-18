/**
 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-perfect-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2;
        long right = num/2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid*mid == num) {
                return true;
            } else if (mid*mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}