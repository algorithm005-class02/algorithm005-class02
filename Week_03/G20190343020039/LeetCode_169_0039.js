/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  let count = 0;
  let candidate = null;
  for (let i = 0; i < nums.length; i += 1) {
    const num = nums[i];
    if (count === 0) {
      candidate = num;
    }
    count += num === candidate ? 1 : -1;
  }
  return candidate;
};
