/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
  // dp[row][col] = min(dp[row+1][col], dp[row+1][col+1]) + triangle[row][col]
  for (let row = triangle.length - 2; row >= 0; row -= 1) {
    for (let col = 0; col < triangle[row].length; col += 1) {
      triangle[row][col] = Math.min(triangle[row+1][col],
        triangle[row+1][col+1]) + triangle[row][col];
    }
  }
  return triangle[0][0];
};
