/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    //进位值
    let adv = 1;
    for ( let i = digits.length - 1; i >= 0; i-- ) {
        let val = digits[i];
        let addVal = val + adv;
        // 取余
        let pv = addVal % 10;
        // 取进位
        adv = (addVal / 10) >> 0;
        digits[i] = pv;
    }
    // 升位
    if( adv > 0 ) digits = [adv].concat(digits);
    return digits;
};
// @lc code=end

