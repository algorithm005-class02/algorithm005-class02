/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let first = 0
    for(let i in nums) {
        if(nums[i] != 0) {
            if(i != first){
                nums[first] = nums[i]
                nums[i] = 0
            }
            first ++
        }
    }
};
// @lc code=end

