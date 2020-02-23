var minPathSum = function (grid) {
const dp = Array.from(grid)
// 倒序 行
for (let i = grid.length - 1; i >= 0; i--) {
  // 列
  for (let j = grid[0].length - 1; j >= 0; j--) {
    // 最底下
    if (i == grid.length - 1 && j != grid[0].length - 1)
      dp[i][j] = grid[i][j] + dp[i][j + 1];
      // 最右边
    else if (j == grid[0].length - 1 && i != grid.length - 1)
      dp[i][j] = grid[i][j] + dp[i + 1][j];
      // 中间
    else if (j != grid[0].length - 1 && i != grid.length - 1)
      dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
    else
    // 右下角
      dp[i][j] = grid[i][j];
  }
}
return dp[0][0];
}
