/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
  if (!matrix || !matrix.length) return 0;
  let max = 0;
  for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[i].length; j++) {
          if (i > 0 && j > 0 && matrix[i][j] !== "0") {
              matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1]) + 1;
          }
          max = Math.max(max, matrix[i][j]);
      }
  }
  return max * max;
};