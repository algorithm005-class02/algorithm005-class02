/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if( nums.length <= 1 ) return nums.length;

    let cursor = 0;
    nums.forEach( ( num , index)=>{
        if( nums[cursor] != num ){
            cursor++;
            if( cursor !== index ) nums[cursor] = num;
        }
    } )

    return cursor+1;
};
// @lc code=end

