/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
  /*
  状态: dp[i][2]
  dp[i][0] 表示从 0->i (包括第i个节点)的正的最大值。
  dp[i][1] 表示从 0->i (包括第i个节点)的负的最大值，也就是最小值。

  dp[i][0] =
    if (nums[i] >= 0) dp[i-1][0]*nums[i]
    else dp[i-1][1]*nums[i]

  dp[i][1] =
    if (nums[i] >= 0) dp[i-1][1]*nums[i]
    else dp[i-1][0]*nums[1]

  结果: max(dp[i][0], dp[i-1][0], ..., dp[0][0])
  */

  if (nums.length === 0) {
    return 0;
  }
  let dp = new Array(2).fill(null).map(() => {
    return new Array(2).fill(null);
  });
  dp[0][0] = nums[0];
  dp[0][1] = nums[0];
  let result = dp[0][0];
  for (let i = 1; i < nums.length; i += 1) {
    let cur = i % 2;
    let pre = (i - 1) % 2;
    dp[cur][0] = Math.max(dp[pre][0]*nums[i], dp[pre][1]*nums[i], nums[i]);
    dp[cur][1] = Math.min(dp[pre][0]*nums[i], dp[pre][1]*nums[i], nums[i]);
    result = Math.max(result, dp[cur][0]);
  }
  return result;
};
