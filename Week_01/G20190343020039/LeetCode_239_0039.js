/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
  if (nums.length === 0) { return []; }
  let result = [];
  let window = [];
  for (let i = 0; i < nums.length; i += 1) {
    if (i >= k && window[0] <= i - k) {
      window.shift();
    }
    while (window.length > 0 && nums[window[window.length - 1]] <= nums[i]) {
      window.pop();
    }
    window.push(i);
    if (i >= k - 1) {
      result.push(nums[window[0]]);
    }
  }
  return result;
};
