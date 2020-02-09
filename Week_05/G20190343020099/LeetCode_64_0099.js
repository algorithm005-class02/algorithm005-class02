/**
 * @param {number[][]} grid
 * @return {number}
 */
// dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
var minPathSum = function(grid) {
  if (!grid || !grid.length) return 0;
  for (let i = 0; i < grid.length; i++) {
      for (let j = 0; j < grid[i].length; j++) {
          if (i === 0) {
              if (j > 0) grid[i][j] += grid[i][j - 1];
          } else if (j === 0) {
              if (i > 0) grid[i][j] += grid[i - 1][j];
          } else {
              if (i > 0 && j > 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
          }
      }
  }
  return grid[grid.length - 1][grid[grid.length - 1].length - 1];
};