/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let result = [];
  dfs(n, 0, [], result, new Set(), new Set(), new Set());

  for (let i = 0; i < result.length; i += 1) {
    for (let j = 0; j < result[i].length; j += 1) {
      const x = result[i][j];
      result[i][j] = '.'.repeat(x) + 'Q' + '.'.repeat(n - x - 1);
    }
  }

  return result;
};

function dfs(n, row, cur, result, cols, pie, na) {
  if (row >= n) {
    result.push(cur.slice());
    return;
  }

  for (let col = 0; col < n; col += 1) {
    if (cols.has(col) ||
      pie.has(row + col) ||
      na.has(row - col)) {
      continue;
    }

    cols.add(col);
    pie.add(row + col);
    na.add(row - col);
    cur.push(col);

    dfs(n, row + 1, cur, result, cols, pie, na);

    cur.pop();
    cols.delete(col);
    pie.delete(row + col);
    na.delete(row - col);
  }
}
