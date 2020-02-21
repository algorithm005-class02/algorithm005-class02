/*
 * @lc app=leetcode.cn id=151 lang=javascript
 *
 * [151] 翻转字符串里的单词
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
    for(let i = len - 1; i >= 0; i--) {
        if(arr[i] != '') {
            arr1.push(arr[i])
        }
    }

    return arr1.join(" ")
};
// @lc code=end

