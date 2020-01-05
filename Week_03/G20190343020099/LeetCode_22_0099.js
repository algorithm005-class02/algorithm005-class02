/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let ans = [];
  helper(0, 0, n, '', ans);
  return ans;
};

function helper (left, right, n, s, ans) {
  // termination
  if (left == n && right == n) {
      return ans.push(s);
  }
  // process
  // drill down
  if (left < n) helper (left + 1, right, n, s + '(', ans);
  if (right < left) helper (left, right + 1, n, s + ')', ans);
  // reverse status
}