/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
  let dp = new Array(nums.length).fill(Number.MAX_VALUE);
  dp[0] = 0;
  for (let i = 0; i < nums.length; i += 1) {
    const num = nums[i];
    for (let j = 1; j <= num; j += 1) {
      if (i + j < nums.length) {
        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
      } else {
        break;
      }
    }
  }
  return dp[nums.length - 1];
};
