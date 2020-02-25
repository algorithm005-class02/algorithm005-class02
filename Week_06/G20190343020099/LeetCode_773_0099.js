/**
 * @param {number[][]} board
 * @return {number}
 */
function slidingPuzzle (board) {
  let min = Number.MAX_VALUE;
  const target = '1,2,3,4,5,0';
  const cost = {};

  for (let r = 0; r < 2; r++) {
    for (let c = 0; c < 3; c++) {
      if (board[r][c] === 0) {
        dfs(r, c, 0);
        return min === Number.MAX_VALUE ? -1 : min;
      }
    }
  }

  function dfs(r, c, len) {
    let hash = board[0].join(',') + ',' + board[1].join(',');
    if (cost[hash] !== undefined && len >= cost[hash]) return;
    cost[hash] = len;

    if (hash === target) {
      min = Math.min(min, len);
      return;
    }

    for (let move of [[-1, 0], [1, 0], [0, -1], [0, 1]]) {
      const [rr, cc] = [r+move[0], c+move[1]];
      if (rr < 0 || cc < 0 || rr === 2 || cc === 3) continue;

      [board[r][c], board[rr][cc]] = [board[rr][cc], board[r][c]];
      dfs(rr, cc, len+1);
      [board[r][c], board[rr][cc]] = [board[rr][cc], board[r][c]];
    }
  }
}