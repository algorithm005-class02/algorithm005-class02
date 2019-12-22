/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let numsObj = {};
    for (let i = 0; i < nums.length; i++) {
        let res = target - nums[i];
        if (typeof numsObj[res] !== 'undefined') {
            return [numsObj[res], i];
        }
        else {
            numsObj[nums[i]] = i;
        }
    }
};
