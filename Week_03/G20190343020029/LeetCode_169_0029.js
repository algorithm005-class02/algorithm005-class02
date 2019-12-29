/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 多数元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let n = nums.length
    let arr = nums.sort((a, b) => a-b)
    let flag = arr[0]
    let start = 0
    return getArr(arr, flag, start, n)
};

let getArr = (arr, flag, start, n) => {
    let len = n / 2
    for (let i = start; i < n; i++) {
        if (flag != arr[i]) {
            let a = arr.slice(start, i)
            if (a.length > len) {
                return flag
            } else {
                let start1 = i
                return getArr(arr, arr[start1], start1, n)
            }
        }
    }
    return flag
}
// @lc code=end

