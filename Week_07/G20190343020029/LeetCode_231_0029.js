/*
 * @lc app=leetcode.cn id=231 lang=javascript
 *
 * [231] 2的幂
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    while (n > 1) {
        if(n % 2 === 0) {
            n = n / 2
        } else {
            break;
        }
    }

    if (n === 1 ) {
        return true
    } else {
        return false
    }
};
// @lc code=end

