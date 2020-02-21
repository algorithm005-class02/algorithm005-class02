/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
  let dp = new Array(amount+1).fill(Number.MAX_VALUE);
  dp[0] = 0;
  for (let i = 0; i < coins.length; i += 1) {
    const coin = coins[i];
    for (let x = coin; x <= amount; x += 1) {
      dp[x] = Math.min(dp[x], dp[x-coin]+1);
    }
  }
  return dp[amount] === Number.MAX_VALUE ? -1 : dp[amount];
};
