/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let ans = [];
  backtrack(ans, n);
  return ans;
};

function backtrack(ans, n, board = [], row = 0) {
  if (row === n) {
      ans.push(board.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - c -1)));
      return ;
  }
  for (let c = 0; c < n; c++) {
      if (!board.some((bc, br) => (c === bc || row === br || bc === c + row - br || bc === c - row + br))) {
          board.push(c);
          backtrack(ans, n, board, row + 1);
          board.pop();
      }
  }
}