/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
  if (!s) return 0;
  let ans = 0;
  let dp = Array.from(Array(s.length), () => Array(s.length));
  for (let i = 0; i < s.length; i++) {
      for (let j = i; j >= 0; j--) {
          if (s.charAt(i) == s.charAt(j) && ((i - j < 2) || dp[j + 1][i - 1])) {
              dp[j][i] =  true;
              ans++;
          }
      }
  }
  return ans;
};