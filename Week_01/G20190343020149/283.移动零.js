/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let i = 0;
    // 需要向前移动的位数
    let forwardSteps = 0;
    while ( i < nums.length) {
        if ( nums[i] === 0 ) {
            // 填充后后续数据需要前移
            forwardSteps++;
        } else if( forwardSteps > 0 ){
            // 数据前移且原位置替换为0
            nums[ i - forwardSteps ] = nums[i];
            nums[ i ] = 0;
        }
        i++;
    }
};
// @lc code=end
// let case1 = [0,1,0,3,12]; moveZeroes(case1)
// console.log( case1 );

