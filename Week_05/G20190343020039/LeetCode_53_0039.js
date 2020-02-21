/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  // dp[i] = max(dp[i-1]+nums[i], nums[i])
  let cur = nums[0];
  let maxsum = nums[0];
  for (let i = 1; i < nums.length; i += 1) {
    cur = Math.max(cur+nums[i], nums[i]);
    maxsum = Math.max(maxsum, cur);
  }
  return maxsum;
};
