/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  if (grid.length === 0) {
    return 0;
  }
  let rows = grid.length;
  let cols = grid[0].length;
  let count = 0;
  for (let i = 0; i < rows; i += 1) {
    for (let j = 0; j < cols; j += 1) {
      if (grid[i][j] === "1") {
        count += 1;
        destroyIsland(grid, i, j);
      }
    }
  }
  return count;
};

function destroyIsland(grid, row, col) {
  const dirs = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
  ];
  grid[row][col] = "0";
  let queue = [];
  queue.push([row, col]);
  while (queue.length > 0) {
    let cur = queue.shift();
    let curRow = cur[0];
    let curCol = cur[1];
    for (let i = 0; i < dirs.length; i += 1) {
      let newRow = curRow + dirs[i][0];
      let newCol = curCol + dirs[i][1];
      if (isIndexValid(grid, newRow, newCol) &&
        grid[newRow][newCol] === "1") {
        grid[newRow][newCol] = "0";
        queue.push([newRow, newCol]);
      }
    }
  }
}

function isIndexValid(grid, row, col) {
  if (row < 0 || col < 0) {
    return false;
  }
  if (row >= grid.length) {
    return false;
  }
  if (col >= grid[0].length) {
    return false;
  }
  return true;
}
