/**
 * 解法一
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                return [i, j]
            }
        }
    }
    return [];
};


/**
 * 解法二
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    if (!nums) return [];
    let map = {};
    for (let i = 0; i < nums.length; i++) {
        if (map.hasOwnProperty(target - nums[i])) {
            return [map[target - nums[i]], i]
        }
        map[nums[i]] = i;
    }
    return [];
};