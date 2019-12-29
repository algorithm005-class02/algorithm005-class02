/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let result = [];
  recursion(result, 0, 0, n, "");
  return result;
};

function recursion(result, left, right, n, strs) {
  if (left === n && right === n) {
    result.push(strs);
    return;
  }
  if (left < n) {
    recursion(result, left + 1, right, n, strs + "(");
  }
  if (right < left) {
    recursion(result, left, right + 1, n, strs + ")");
  }
}
