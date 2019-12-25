/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let result = [];
  recursion(n, k, 1, [], result);
  return result;
};

function recursion(n, k, first, cur, result) {
  if (cur.length === k) {
    result.push(cur.slice(0))
    return;
  }

  for (let i = first; i <= n; i += 1) {
    cur.push(i);
    recursion(n, k, i + 1, cur, result);
    cur.pop();
  }
}
