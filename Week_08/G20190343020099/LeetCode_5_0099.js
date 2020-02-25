/**
 * @param {string} s
 * @return {string}
 */
// dp[i][j] =
var longestPalindrome = function(s) {
  if (!s) return "";
  let lIndex = 0, len = 0;
  let dp = Array.from({length: s.length}, _ => Array(s.length))
  for (let i = s.length - 1; i >= 0; i--) {
      for (let j = i; j < s.length; j++) {
          dp[i][j] = s[i] === s[j] && ((j - i < 2) || dp[i + 1][j - 1])
          if (dp[i][j] && j - i + 1 > len) {
              len = j - i + 1;
              lIndex = i;
          }
      }
  }
  return s.substr(lIndex, len);
};