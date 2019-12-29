/**
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