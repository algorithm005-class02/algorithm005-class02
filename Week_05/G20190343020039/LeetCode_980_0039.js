/**
 * @param {number[][]} grid
 * @return {number}
 */
var uniquePathsIII = function(grid) {
  let rows = grid.length;
  let cols = grid[0].length;
  const ctx = {
    result: 0,
  };
  let startRow = 0;
  let startCol = 0;
  let endRow = 0;
  let endCol = 0;
  let empty = 1;
  for (let row = 0; row < rows; row += 1) {
    for (let col = 0; col < cols; col += 1) {
      if (grid[row][col] === 0) {
        empty += 1;
      } else if (grid[row][col] === 1) {
        startRow = row;
        startCol = col;
      } else if (grid[row][col] === 2) {
        endRow = row;
        endCol = col;
      }
    }
  }
  dfs(grid, startRow, startCol, endRow, endCol, empty, ctx);
  return ctx.result;
};

function dfs(grid, startRow, startCol, endRow, endCol, empty, ctx) {
  if (startRow < 0 || startRow >= grid.length ||
    startCol < 0 || startCol >= grid[0].length ||
    grid[startRow][startCol] < 0) {
    return;
  }
  if (startRow === endRow && startCol === endCol) {
    if (empty === 0) {
      ctx.result += 1;
    }
    return;
  }
  grid[startRow][startCol] = -2;
  dfs(grid, startRow+1, startCol, endRow, endCol, empty-1, ctx);
  dfs(grid, startRow-1, startCol, endRow, endCol, empty-1, ctx);
  dfs(grid, startRow, startCol+1, endRow, endCol, empty-1, ctx);
  dfs(grid, startRow, startCol-1, endRow, endCol, empty-1, ctx);
  grid[startRow][startCol] = 0;
}
