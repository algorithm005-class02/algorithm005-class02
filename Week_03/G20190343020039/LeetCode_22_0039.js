/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let result = [];
  recursion(n, 0, 0, "", result);
  return result;
};

function recursion(n, left, right, cur, result) {
  if (left === n && right === n) {
    result.push(cur);
    return;
  }

  if (left < n) {
    recursion(n, left + 1, right, cur + "(", result);
  }

  if (right < left) {
    recursion(n, left, right + 1, cur + ")", result);
  }
}
