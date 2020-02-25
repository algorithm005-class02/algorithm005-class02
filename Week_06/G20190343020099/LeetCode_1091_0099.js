/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function (grid) {
  let _y = grid.length - 1;
  let _x = grid[0].length - 1;
  if (grid[_y][_x] || grid[0][0]) return -1
  let arr = [[0, 0]];
  grid[0][0] = 1;
  let res = 1;
  while (arr.length) {
    let temp = [];
    for (let i = 0, len = arr.length; i < len; ++i) {
      let [y, x] = arr[i]
      if (y === _y && x === _x) return res;
      if (y < _y) {
        if (!grid[y+1][x]) {temp.push([y+1, x]); grid[y+1][x] = 1;};
        if (x < _x && !grid[y+1][x+1]) {temp.push([y+1, x+1]), grid[y+1][x+1] = 1;}
        if (x > 0 && !grid[y+1][x-1]) {temp.push([y+1, x-1]), grid[y+1][x-1] = 1;}
      }
      if (x < _x && !grid[y][x+1]) {temp.push([y, x+1]), grid[y][x+1] = 1;}
      if (x > 0 && !grid[y][x-1]) {temp.push([y, x-1]), grid[y][x-1] = 1;}
      if (y > 0) {
        if (!grid[y-1][x]) {temp.push([y-1, x]); grid[y-1][x] = 1}
        if (x < _x && !grid[y-1][x+1]) {temp.push([y-1, x+1]); grid[y-1][x+1] = 1}
        if (x > 0 && !grid[y-1][x-1]) {temp.push([y-1, x-1]); grid[y-1][x-1] = 1}
      }
    }
    ++res;
    arr = temp;
  }
  return -1;
};