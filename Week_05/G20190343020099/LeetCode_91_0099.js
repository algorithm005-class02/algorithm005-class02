/**
 * 解法一：动态规划
 * @param {string} s
 * @return {number}
 */
// if(s[i - 1] = 1 || (s[i - 1] = 2 && s[i] < 7)) dp[i]  = dp[i - 1] + dp[i - 2]
var numDecodings = function(s) {
  if (s[0] === '0') return 0;
  let dp = [1];
  for (let i = 1; i < s.length; i++) {
      if (s[i] === '0') {
          if(s[i - 1] === '0' || s[i - 1] > 2) return 0;
          dp[i] = i > 1 ? dp[i - 2] : 1
      } else if (s[i - 1] === '1' || (s[i - 1] === '2' && s[i] < '7')) {
          dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
      } else {
          dp[i] = dp[i - 1]
      }
  }
  return dp[dp.length - 1]
};


/**
 * 解法二：动态规划优化
 * @param {string} s
 * @return {number}
 */
// if(s[i - 1] = 1 || (s[i - 1] = 2 && s[i] < 7)) dp[i]  = dp[i - 1] + dp[i - 2]
var numDecodings = function(s) {
  if (s[0] === '0') return 0;
  let pre = 1;
  let ppre = 1;
  let curr = 1;
  for (let i = 1; i < s.length; i++) {
      if (s[i] === '0') {
          if(s[i - 1] === '0' || s[i - 1] > 2) return 0;
          curr = ppre;
      } else if (s[i - 1] === '1' || (s[i - 1] === '2' && s[i] < '7')) {
          curr = pre + ppre;
      } else {
          curr = pre
      }
      ppre = pre;
      pre = curr;
  }
  return curr
};