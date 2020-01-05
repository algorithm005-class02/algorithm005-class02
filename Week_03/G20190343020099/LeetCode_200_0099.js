/**
 * 解法一
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  if (!grid || grid.length === 0) return 0;
  let ans = 0;
  for (let r = 0; r < grid.length; r++) {
      for (let c = 0; c < grid[0].length; c++) {
          ans += sink(grid, r, c);
      }
  }
  return ans;
};

function sink (grid, r, c) {
  if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] === '0') return 0;
  grid[r][c] = '0';
  sink(grid, r + 1, c);
  sink(grid, r - 1, c);
  sink(grid, r, c + 1);
  sink(grid, r, c - 1);
  return 1;
}


/**
 * 解法二
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  if (!grid || grid.length === 0) return 0;
  let ans = 0;
  for (let r = 0; r < grid.length; r++) {
      for (let c = 0; c < grid[0].length; c++) {
          if (grid[r][c] === '1') {
              ans++;
              dfs(grid, r, c);
          }
      }
  }
  return ans;
};

function dfs (grid, r, c) {
  if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] === '0') return ;
  grid[r][c] = '0';
  dfs(grid, r + 1, c);
  dfs(grid, r - 1, c);
  dfs(grid, r, c + 1);
  dfs(grid, r, c - 1);
}