/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
  let dp = new Array(coins.length+1).fill(null).map(() => {
    return new Array(amount+1).fill(0);
  });
  dp[0][0] = 1;
  for (let i = 1; i <= coins.length; i += 1) {
    dp[i][0] = 1;
    for (let j = 1; j <= amount; j += 1) {
      if (j >= coins[i-1]) {
        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
      } else {
        dp[i][j] = dp[i-1][j];
      }
    }
  }
  return dp[coins.length][amount];
};
