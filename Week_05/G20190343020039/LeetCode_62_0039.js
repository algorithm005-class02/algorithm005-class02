/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  let rows = n;
  let cols = m;
  let dp = new Array(rows).fill(null).map(() => {
    return new Array(cols).fill(0);
  });
  dp[rows-1][cols-1] = 1;
  for (let row = rows - 2; row >= 0; row -= 1) {
    dp[row][cols-1] = 1;
  }
  for (let col = cols - 2; col >= 0; col -= 1) {
    dp[rows-1][col] = 1;
  }
  for (let row = rows - 2; row >= 0; row -= 1) {
    for (let col = cols - 2; col >= 0; col -= 1) {
      dp[row][col] = dp[row+1][col] + dp[row][col+1];
    }
  }
  return dp[0][0];
};
