/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
  if (board === null || board.length <= 0 || board[0].length <= 0) return board;
  let rows = board.length,
      cols = board[0].length;
  for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
          let isEdge = (i === 0 || j === 0 || i == rows-1 || j === cols-1);
          if (isEdge && board[i][j] === "O") {
              dfs(board, i, j);
          }
      }
  }
  for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
          if (board[i][j] === "O") {
              board[i][j] = "X"
          } else if (board[i][j] === "#") {
              board[i][j] = "O"
          }
      }
  }
  return board;
};

function dfs(board, i, j) {
  if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] === "X" || board[i][j] === "#") {
      return;
  }
  board[i][j] = "#";
  dfs(board, i-1, j);
  dfs(board, i, j+1);
  dfs(board, i+1, j);
  dfs(board, i, j-1);
}