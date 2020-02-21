/*
 * @lc app=leetcode.cn id=1122 lang=javascript
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    arr1 = arr1.sort((a,b) => { return a - b})
    let len = arr1.length
    let ff = 0
    for (let i of arr2) {
        let num = i
        for(let i = ff; i < len; i++) {
            if (arr1[i] === num) {
                if(i != ff) {
                    arr1.splice(ff, 0, arr1.splice(i, 1))
                }
                ff++
            }
        }
    }
    return arr1
};
// @lc code=end

