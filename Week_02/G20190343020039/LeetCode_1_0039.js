/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  const m = new Map();
  for (let i = 0; i < nums.length; i += 1) {
    const num = nums[i];
    const peer = target - num;
    if (m.has(peer)) {
      return [m.get(peer), i];
    }
    m.set(num, i);
  }
};
