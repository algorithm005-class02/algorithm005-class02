/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    if(n <= 2) {
        return n
    }
    let num1 = 1
    let num2 = 2
    let numN = 0
    for(let i = 2; i < n; i++){
        numN = num1 + num2
        num1 = num2
        num2 = numN
    }
    return numN
};
// @lc code=end

