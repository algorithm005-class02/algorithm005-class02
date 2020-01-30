/*
 * @lc app=leetcode.cn id=78 lang=cpp
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.55%)
 * Likes:    443
 * Dislikes: 0
 * Total Accepted:    55.7K
 * Total Submissions: 73.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
public:

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        if(nums.size() == 0) return res;
        vector<int> temp;
        helper(res, nums, temp, 0);
        return res;
    }
private:
    void helper(vector<vector<int>>& res, vector<int>& nums, vector<int> temp, int level){
 /*
        if(temp.size() <= nums.size()){
            res.push_back(temp);
        }
        for(int i = level; i < nums.size(); i++){
            temp.push_back(nums[i]);
            helper(res,nums,temp,i+1);
            temp.pop_back();
        }
    }
    */
        if(level == nums.size()){
            res.push_back(temp);
            return;
        }

        helper(res, nums, temp, level+1);
        temp.push_back(nums[level]);
        helper(res, nums, temp, level+1);
        temp.pop_back();
    }
};
// @lc code=end

