/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
  if (matrix === null || matrix.length === 0) {
    return 0;
  }
  let rows = matrix.length;
  let cols = matrix[0].length;
  let dp = new Array(rows+1).fill(null).map(() => {
    return new Array(cols+1).fill(0);
  });
  let result = 0;
  for (let i = 1; i <= rows; i += 1) {
    for (let j = 1; j <= cols; j += 1) {
      if (matrix[i-1][j-1] === '1') {
        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
        result = Math.max(result, dp[i][j]);
      }
    }
  }
  return result*result;
};
