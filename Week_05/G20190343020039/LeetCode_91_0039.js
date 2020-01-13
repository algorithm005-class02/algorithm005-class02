/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
  if (s === null || s.length === 0) { return 0; }
  let dp = new Array(s.length).fill(0);
  dp[0] = s.charAt(0) !== '0' ? 1 : 0;
  for (let i = 1; i < s.length; i += 1) {
    const first = +s.charAt(i);
    const second = +s.substring(i-1, i+1);
    if (first >= 1 && first <= 9) {
      dp[i] += dp[i-1];
    }
    if (second >= 10 && second <= 26) {
      dp[i] += i >= 2 ? dp[i-2] : 1;
    }
  }
  return dp[s.length-1];
};
