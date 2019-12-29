/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let arr = new Array()
    let len = nums.length
    for(let i = 0; i < len; i++) {
        for(let j = i + 1; j < len; j++) {
            if(nums[i] + nums[j] == target) {
                return [i, j]
            }
        }
    }
    return []
};
// @lc code=end

