/*
 * @lc app=leetcode.cn id=152 lang=cpp
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (36.69%)
 * Likes:    367
 * Dislikes: 0
 * Total Accepted:    32.6K
 * Total Submissions: 88.6K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        //维护最大值和最小值
        int dp[nums.size()];
        int maxdp = nums[0];
        int mindp = nums[0];
        int result = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.size(); i++){
            int temp = maxdp;
            maxdp = max(max(maxdp * nums[i], nums[i]), mindp * nums[i]);
            mindp = min(min(temp * nums[i], nums[i]), mindp * nums[i]);
            dp[i] = max(dp[i-1], maxdp);
            result = dp[i] > result ? dp[i] : result;

        }
        return result;
    }
};
// @lc code=end

