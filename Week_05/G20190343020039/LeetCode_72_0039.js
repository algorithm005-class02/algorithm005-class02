/**
* @param {string} word1
* @param {string} word2
* @return {number}
*/
var minDistance = function(word1, word2) {
  let rows = word1.length+1;
  let cols = word2.length+1;
  let dp = new Array(rows).fill(null).map(() => {
    return new Array(cols).fill(0);
  });
  for (let row = 1; row < rows; row += 1) {
    dp[row][0] = row;
  }
  for (let col = 1; col < cols; col += 1) {
    dp[0][col] = col;
  }
  for (let row = 1; row < rows; row += 1) {
    for (let col = 1; col < cols; col += 1) {
      if (word1[row-1] == word2[col-1]) {
        dp[row][col] = 1 + Math.min(dp[row-1][col],
          dp[row][col-1], dp[row-1][col-1]-1);
      } else {
        dp[row][col] = 1 + Math.min(dp[row-1][col],
          dp[row][col-1], dp[row-1][col-1]);
      }
    }
  }
  return dp[word1.length][word2.length];
};
