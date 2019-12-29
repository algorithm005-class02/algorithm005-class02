/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let sArr = s.split("").sort()
    let tArr = t.split("").sort()
    if(sArr.length != tArr.length) {
        return false
    } else {
        return sArr.every((item, index) => {
                    return item == tArr[index]
                })
    }
};
// @lc code=end

