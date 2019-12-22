/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    
    for (let i = 0; i < nums.length; i++) {

        let element = nums[i]
        let b = target - element
        for (let j = i+1; j < nums.length; j++) {

            if (b == nums[j]) return [i, j]
        }
    }
    return []
};