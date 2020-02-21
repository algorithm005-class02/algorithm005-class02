/*
 * @lc app=leetcode.cn id=367 lang=cpp
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (42.92%)
 * Likes:    86
 * Dislikes: 0
 * Total Accepted:    22K
 * Total Submissions: 51.3K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    bool isPerfectSquare(int num) {
        int left = 0;
        int right = num/2 + 1;
        while(left < right){
            long mid = (left + right + 1) >> 1;
            long square = mid*mid;
            if(square > num)
                right = mid - 1;
            else    left = mid;
        }
        if(left*left == num) return true;
        else return false;
    }
};
// @lc code=end

