/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
  // dp[i] = min(dp[i - 完全平方数]) + 1
  let dp = new Array(n+1).fill(0);
  for (let i = 1; i <= n; i += 1) {
    dp[i] = i;
    for (let j = 1; i - j * j >= 0; j += 1) {
      dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    }
  }
  return dp[n];
};
