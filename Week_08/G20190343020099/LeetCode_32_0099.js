/**
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