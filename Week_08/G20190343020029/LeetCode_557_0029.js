/*
 * @lc app=leetcode.cn id=557 lang=javascript
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = s.split(" ")
    let len = arr.length
    let arr1 = new Array()

    for(let i = 0; i < len; i++) {
        if(arr[i] != "") {
            arr1.push(arr[i].split('').reverse().join(''))
        }
    }

    return arr1.join(" ")
};
// @lc code=end

