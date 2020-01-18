/**
 * @param {number} N
 * @return {number}
 */
var fib = function(N) {
  if (N < 2) {
    return N;
  }
  let f1 = 0;
  let f2 = 1;
  for (let i = 2; i <= N; i += 1) {
    [f1, f2] = [f2, f1 + f2];
  }
  return f2;
};
