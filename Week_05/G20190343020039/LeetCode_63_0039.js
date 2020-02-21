/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
  let rows = obstacleGrid.length;
  let cols = obstacleGrid[0].length;
  let dp = new Array(rows).fill(null).map(() => {
    return new Array(cols).fill(0);
  });

  dp[rows-1][cols-1] = obstacleGrid[rows-1][cols-1] === 0 ? 1 : 0;

  for (let row = rows - 2; row >= 0; row -= 1) {
    dp[row][cols-1] = (obstacleGrid[row][cols-1] === 0
      && dp[row+1][cols-1] === 1) ? 1 : 0;
  }

  for (let col = cols - 2; col >= 0; col -= 1) {
    dp[rows-1][col] = (obstacleGrid[rows-1][col] === 0
      && dp[rows-1][col+1] === 1) ? 1 : 0;
  }

  for (let row = rows - 2; row >= 0; row -= 1) {
    for (let col = cols - 2; col >= 0; col -= 1) {
      if (obstacleGrid[row][col] === 1) {
        dp[row][col] = 0;
      } else {
        dp[row][col] = dp[row+1][col] + dp[row][col+1];
      }
    }
  }

  return dp[0][0];
};
