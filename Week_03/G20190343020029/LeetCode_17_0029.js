/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    let arr = digits.split('')
    if (arr.length == 0) {
        return []
    }
    let obj = {
        2:['a', 'b', 'c'],
        3:['d', 'e', 'f'],
        4:['g', 'h', 'i'],
        5:['j', 'k', 'l'],
        6:['m', 'n', 'o'],
        7:['p', 'q', 'r', 's'],
        8:['t', 'u', 'v'],
        9:['w', 'x', 'y', 'z']
    }
    let res = obj[arr[0]]
    let len = arr.length
    for (let i = 1; i < len; i++) {
        let tem_arr = obj[arr[i]]
        let temp_res = []
        for (let char of tem_arr) {
            for (let index in res) {
                temp_res = temp_res.concat(res[index] + char)
            }
        }
        res = temp_res
    }
    return res;
};
// @lc code=end

