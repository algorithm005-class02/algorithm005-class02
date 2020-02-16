/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let arr = s.split("")
    let temp = new Array()
    for(let i = 0; i < arr.length; i++) {
        let sum = 0
        if(!temp.includes(arr[i])) {
            for(let j = i+1; j < arr.length; j++) {
                if(arr[j] === arr[i]) {
                    sum++
                }
            }
            if(sum === 0) return i
            else temp.push(arr[i])
        }
    }
    return -1
};
// @lc code=end

