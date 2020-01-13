/*
 * @lc app=leetcode.cn id=152 lang=javascript
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let res = Math.max(...nums)
    if (nums.length == 1) {
        return nums[0]
    }

    let f = (i, param) => {
        let res = param
        let sub = 1
        for( let j = i; j >= 0; j--) {
            sub *= nums[j]
            res = Math.max(res, sub)
        }
        return res
    }

    for (let i = 1; i <nums.length; i++) {
        res = f(i, res)
    }

    return res
};
// @lc code=end

