/**
 * 解法一：暴力循环
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  if (!s) return 0;
  let max = 0;
  for (let i = 0; i < s.length; i++) {
      for (let j = i + 2; j <= s.length; j += 2) {
          if (isValid(s.slice(i, j))) {
              max = Math.max(max, j - i);
          }
      }
  }
  return max;
};

function isValid(s) {
  let stack = [];
  for (let i of s) {
      if (i === '(') {
          stack.push('(')
      } else if (stack.length > 0 && i === ')') {
          stack.pop();
      } else {
          return false;
      }
  }
  return stack.length === 0;
}

/**
 * 解法二：利用 stack
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  if (!s) return 0;
  let stack = [-1];
  let max = 0;
  for (let i = 0; i < s.length; i++) {
      if (s[i] === '(') {
          stack.push(i);
      } else {
          stack.pop();
          if (stack.length === 0) {
              stack.push(i)
          } else {
              max = Math.max(max, i - stack[stack.length - 1]);
          }
      }
  }
  return max;
};



/**
 * 解法三：动态规划
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  if (!s) return 0;
  let dp = Array(s.length).fill(0);
  let max = 0;
  for (let i = 1; i < s.length; i++) {
      if (s[i] === ')') {
          if (s[i - 1] === '(') {
              dp[i] = ((i > 2) ? dp[i - 2] : 0) + 2;
              max = Math.max(max, dp[i]);
          } else if ((i - dp[i - 1] - 1) >= 0 && s[i - dp[i - 1] - 1] === '(') {
              dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0)
              max = Math.max(max, dp[i]);
          }
      }
  }
  return max;
};


/**
 * 解法四：两次循环 时间复杂度 O(N) 空间复杂度O(1)
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  if (!s) return 0;
  let max = 0;
  let left = 0;
  let right = 0;
  for (let i = 0; i < s.length; i++) {
      if (s[i] === '(') {
          left++;
      } else {
          right++;
      }
      if (right > left) {
          left = 0;
          right = 0;
      }else if (left === right) {
          max = Math.max(max, 2 * right);
      }
  }
  left = 0;
  right = 0;
  for (let i = s.length - 1; i >= 0; i--) {
      if (s[i] === ')') {
          right++;
      } else {
          left++;
      }
      if (left > right) {
          left = 0;
          right = 0;
      } else if (left === right) {
          max = Math.max(max, 2 * left);
      }
  }
  return max;
};