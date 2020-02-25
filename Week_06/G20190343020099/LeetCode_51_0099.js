/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let result = [];
  function dfs(cols) {
      let row = cols.length;
      if (row === n) return result.push(cols.map(col => '.'.repeat(col) + 'Q' + '.'.repeat(n - col -1)));
      for (let col = 0; col < n; col++) {
          if(cols.some((exCol, exRow) => (exCol == col || exRow - exCol == row - col || exRow + exCol == row + col))) continue;
          dfs(cols.concat(col))
      }
  }
  dfs([]);
  return result;
};