/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
  // 二维棋盘
  const board = Array.from({ length: n }, () => Array.from({ length: n }, () => '.'))
  // 关键：3个一维布尔数组，用以记录是否已占有
  const col = Array.from({ length: n }, () => false)
  const diagLeft = Array.from({ length: 2 * n - 1 }, () => false)
  const diagRight = Array.from({ length: 2 * n - 1 }, () => false)
  // 保存结果
  const res = []

  function backtrack (i) {
    if (i === n) {
      res.push(board.map(row => row.join('')))
      return
    }

    for (let j = 0; j < n; ++j) { // 遍历第`i`行中所有列`j`
      // 算2个对角线的下标
      const l = i + j
      const r = j - i + n - 1

      if (!col[j] && !diagLeft[l] && !diagRight[r]) {
        // 探索
        col[j] = diagLeft[l] = diagRight[r] = true
        board[i][j] = 'Q'
        backtrack(i + 1)
        // 回溯
        col[j] = diagLeft[l] = diagRight[r] = false
        board[i][j] = '.'
      }
    }
  }

  backtrack(0)
  return res
};