/*
 * @lc app=leetcode.cn id=50 lang=cpp
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (33.53%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    47.4K
 * Total Submissions: 140.7K
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
class Solution {
public:
    double myPow(double x, int n) {
        /* 暴力
        double res = 1;
        int n_abs = n > 0 ? n : -n;
        for(int i = 0; i < n_abs ; i ++){
            res *= x;
        }
        return n > 0 ? res : 1/res;
        */
       
       unsigned int N = n;
        if(n < 0){
            x = 1/x;
            N = -N;          
        }
        return fastpow(x,N);
        
    }
    
private:
    double fastpow(double x, unsigned int n){
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n == 2) return x*x;
        double half = fastpow(x,n/2);
        if(n % 2 == 1){
            return half * half * x;
        }
        else return half * half;
    }
    
};
// @lc code=end

