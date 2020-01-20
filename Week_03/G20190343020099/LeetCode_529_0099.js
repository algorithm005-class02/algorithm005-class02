/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
  let [row, col] = click;
  let rowSize = board.length;
  let colSize = board[0].length;
  if (row >= rowSize || col >= colSize || row < 0 || col < 0) return board;
  if (board[row][col] === 'M') {
      board[row][col] = 'X';
      return board;
  }
  let dx = [-1, -1, -1, 0, 1, 1, 1, 0];
  let dy = [-1, 0, 1, 1, 1, 0, -1, -1];
  let count = 0;
  for (let i = 0; i < 8; i++) {
      let nextRow = row + dx[i];
      let nextCol = col + dy[i];
      if (nextRow >= rowSize || nextCol >= colSize || nextRow < 0 || nextCol < 0) continue;
      if (board[nextRow][nextCol] === 'M' || board[nextRow][nextCol] === 'X') count++;
  }
  if (count > 0 ) {
      board[row][col] = count + '';
  } else {
      board[row][col] = 'B';
      for (let i = 0; i < 8; i++) {
          let nextRow = row + dx[i];
          let nextCol = col + dy[i];
          if (nextRow >= rowSize || nextCol >= colSize || nextRow < 0 || nextCol < 0) continue;
          if (board[nextRow][nextCol] === 'E') updateBoard(board, [nextRow, nextCol]);
      }
  }
  return board;
};