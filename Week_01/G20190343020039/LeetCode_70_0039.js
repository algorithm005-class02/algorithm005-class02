/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
  if (n <= 3) {
    return n;
  }
  let [f1, f2, f3] = [1, 2, 3];
  for (let i = 3; i < n; i += 1) {
    [f1, f2, f3] = [f2, f3, f2 + f3]
  }
  return f3;
};

