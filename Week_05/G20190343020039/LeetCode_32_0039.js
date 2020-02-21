/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  /*
  dp[i] 为以下标 i 结尾的最长有效子字符串的长度。

  s[i] == ')' && s[i-1] == '('
    dp[i] = dp[i-2] + 2

  s[i] == ')' && s[i-1] == ')' && s[i - dp[i-1] - 1] == '('
    dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
  */
  let result = 0;
  let dp = new Array(s.length).fill(0);
  for (let i = 1; i < s.length; i += 1) {
    if (s.charAt(i) === '(') {
      continue;
    }
    if (s.charAt(i-1) === '(') {
      dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
    } else if (i - dp[i-1] && s.charAt(i - dp[i-1] - 1) === '(') {
      dp[i] = dp[i-1] + (i - dp[i-1] >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
    }
    result = Math.max(result, dp[i]);
  }
  return result;
};
