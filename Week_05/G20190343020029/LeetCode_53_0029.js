/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子序和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let res = Math.max(...nums)
    if (nums.length == 1) {
        return nums[0]
    }

    let f = (i, param) => {
        let res = param
        let sum = 0
        for( let j = i; j >= 0; j--) {
            sum += nums[j]
            res = Math.max(res, sum)
        }
        return res
    }

    for (let i = 1; i <nums.length; i++) {
        res = f(i, res)
    }

    return res
};
// @lc code=end

