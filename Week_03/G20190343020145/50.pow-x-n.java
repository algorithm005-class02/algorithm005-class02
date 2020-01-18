/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (33.52%)
 * Likes:    231
 * Dislikes: 0
 * Total Accepted:    43K
 * Total Submissions: 128.2K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
// 1. 暴力
// class Solution {
//     public double myPow(double x, int n) {
//         if(n < 0){
//             x = 1 / x;
//             n = -n;
//         }

//         double result = 1;
//         for (long i = 0; i < n ;++ i){
//              result = result  * x;
//         }

//         return result;
        
//     }
// }

//2.分治
class Solution {

    public double myPow(double x, int n) {
        return fastPow(x, n);
    }
    private double fastPow(double x, long n) {
        if(n == 0) return 1.0;
        if(n < 0){
            x = 1 / x;
            n = - n;
        }
        double half = fastPow(x, n/2);
        if(n % 2 == 0){
            half = half * half;
        }
        if(n % 2 == 1){
            half = half * half * x;
        }
        
        return half;

    }


    

}

// @lc code=end

