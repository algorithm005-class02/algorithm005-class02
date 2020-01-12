/**
* @param {number[][]} grid
* @return {number}
*/
var minPathSum = function(grid) {
  // dp[i][j] = grid[i][j] + min(dp[i+1][j]+dp[i][j+1])
  let rows = grid.length;
  let cols = grid[0].length;
  for (let row = rows - 2; row >= 0; row -= 1) {
    grid[row][cols-1] += grid[row+1][cols-1];
  }
  for (let col = cols - 2; col >= 0; col -= 1) {
    grid[rows-1][col] += grid[rows-1][col+1];
  }
  for (let row = rows - 2; row >= 0; row -= 1) {
    for (let col = cols - 2; col >= 0; col -= 1) {
      grid[row][col] = grid[row][col] +
        Math.min(grid[row+1][col], grid[row][col+1]);
    }
  }
  return grid[0][0];
};
