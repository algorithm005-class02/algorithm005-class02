/*
 * @lc app=leetcode.cn id=50 lang=javascript
 *
 * [50] Pow(x, n)
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    if(n == 0) {
        return 1
    }else {
        let res = 1
        let R = 1
        let N = Math.abs(n)
        rem = N % 10
        divider = (N - rem) / 10
        for(let i = 0; i < 10; i++) {
            R *= x
            if(rem > 0){
                res = R
                rem--
            }
        }
        while(divider > 0) {
            res *= R
            divider --
        }
        if(n > 0) {
            return  res
        }else {
            return 1/res
        }
    }
};
// @lc code=end

