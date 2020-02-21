/*
 * @lc app=leetcode.cn id=541 lang=javascript
 *
 * [541] 反转字符串 II
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    if(k === 1) return s

    let arr = s.split("")
    let len = arr.length
    let k2 = 2 * k
    let m = len % k2
    let n = (len - m) / k2

    let temp = 0
    if(m === 0) temp =0
    else if(m < k) temp = 1
    else if(m < k2) temp = 2

    let str = ''
    
    if(n > 0) {
        for(let i = 0; i < n; i++) {
            for(let j = k -1; j >= 0; j--) {
                str += arr[(i*k2)+j]
            }
            for(let j = k; j < k2; j++) {
                str += arr[(i*k2)+j]
            }
        }
    }

    if(temp === 1) {
        for(let i = len - 1; i >= len - m; i--) {
            str += arr[i]
        }
    }else if(temp === 2) {
        for (let i = len - m + k - 1; i > len - m - 1; i--) {
            str += arr[i]
        }
        for(let i = len - m + k; i < len; i++) {
            str += arr[i]
        }
    }

    return str
};
// @lc code=end

