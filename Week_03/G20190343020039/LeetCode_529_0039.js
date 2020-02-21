/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
  let queue = [];
  queue.push(click);
  while (queue.length > 0) {
    let curClick = queue.shift();
    let curRow = curClick[0];
    let curCol = curClick[1];
    if (board[curRow][curCol] === 'M') {
      board[curRow][curCol] = 'X';
      break;
    } else if (board[curRow][curCol] === 'E') {
      let mineCount = findAdjoinMine(board, curRow, curCol);
      if (mineCount === 0) {
        board[curRow][curCol] = 'B';
        let ms = getAdjoinE(board, curRow, curCol);
        for (let i = 0; i < ms.length; i += 1) {
          queue.push(ms[i]);
        }
      } else {
        board[curRow][curCol] = '' + mineCount;
      }
    }
  }
  return board;
};

const dirs = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
  [-1, -1],
  [1, 1],
  [-1, 1],
  [1, -1],
];

function getAdjoinE(board, row, col) {
  let result = [];
  for (let i = 0; i < dirs.length; i += 1) {
    const newRow = row + dirs[i][0];
    const newCol = col + dirs[i][1];
    if (isValidIndex(board, newRow, newCol)) {
      if (board[newRow][newCol] === 'E') {
        result.push([newRow, newCol]);
      }
    }
  }
  return result;
}

function findAdjoinMine(board, row, col) {
  let count = 0;
  for (let i = 0; i < dirs.length; i += 1) {
    const newRow = row + dirs[i][0];
    const newCol = col + dirs[i][1];
    if (isValidIndex(board, newRow, newCol)) {
      if (board[newRow][newCol] === 'M') {
        count += 1;
      }
    }
  }
  return count;
}

function isValidIndex(board, row, col) {
  if (row < 0 || col < 0) {
    return false;
  }
  if (row >= board.length) {
    return false;
  }
  if (col >= board[0].length) {
    return false;
  }
  return true;
}


