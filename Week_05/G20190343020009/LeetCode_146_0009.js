var maximalSquare = function (matrix) {
    let rows = matrix.length -1
    cols = rows >= 0 ? matrix[0].length - 1 : 0
    let dp = Array.from(matrix)
    let maxsqlen = 0;
    for (let i = 0; i <= rows; i++) {
      for (let j = 0; j <= cols; j++) {
          if (matrix[i][j] == '0' || i == 0 || j == 0){
            dp[i][j] = Number.parseInt(matrix[i][j])
          } else {
            dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
          }
          maxsqlen = Math.max(maxsqlen, dp[i][j])
        }
      }
    return maxsqlen * maxsqlen;
  }
