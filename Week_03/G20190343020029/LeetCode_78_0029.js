/*
 * @lc app=leetcode.cn id=78 lang=javascript
 *
 * [78] 子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let res = [[]]
    for(let i = 0; i < nums.length; i++) {
        for(let j = 0, len = res.length; j < len; j++) {
            res.push(res[j].concat(nums[i]))
        }
    }
    return res;
};
// @lc code=end

