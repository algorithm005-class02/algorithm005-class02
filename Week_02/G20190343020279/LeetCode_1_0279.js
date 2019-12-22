/**
 * @method "暴力法"
 * @explain 使用两层循环，当外层循环的当前元素 == target - 内层循环的当前元素时，则返回两个元素的下标。
 * @complexity 时间复杂度：O(n^2),空间复杂度：O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i +1; j < nums.length; j++) {
            //1.当外层元素 = target - 内层元素时返回两个元素的下标
            if (nums[i] == target - nums[j]) return [i,j];
        }
    }
    return [];
};
