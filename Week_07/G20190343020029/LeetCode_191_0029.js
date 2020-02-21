/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0
    
    while(n > 0) {
        let temp = n % 2
        if(temp === 1) count++
        n = (n - temp ) / 2 
    }  
    
    return count
};
// @lc code=end

