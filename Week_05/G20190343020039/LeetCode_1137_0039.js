/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
  if (n < 2) { return n; }
  if (n === 2) { return 1; }
  let f0 = 0;
  let f1 = 1;
  let f2 = 1;
  for (let i = 3; i <= n; i += 1) {
    [f0, f1, f2] = [f1, f2, f0 + f1 + f2];
  }
  return f2;
};

