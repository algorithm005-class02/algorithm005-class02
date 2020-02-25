/**
 * 解法一
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function(S) {
  if (!S) return "";
  let stack = [], ans = [];
  for (let char of S) {
      if (isAlpha(char)) stack.push(char);
  }
  for (let char of S) {
      if (isAlpha(char)) {
          ans.push(stack.pop());
      } else {
          ans.push(char);
      }
  }
  return ans.join('');
};

function isAlpha(c) {
  return /^[a-zA-Z]+$/.test(c);
}


/**
 * 解法二
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function(S) {
  if (!S) return "";
  let ans = [];
  let l = 0, r = S.length - 1;
  while (l < S.length) {
      if (isAlpha(S[l])) {
          while (!isAlpha(S[r])) r--;
          ans.push(S[r--]);
      } else {
          ans.push(S[l]);
      }
      l++;
  }
  return ans.join('');
};

function isAlpha(c) {
  return /^[a-zA-Z]+$/.test(c);
}