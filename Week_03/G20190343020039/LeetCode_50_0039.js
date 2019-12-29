/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
  if (n < 0) {
    x = 1 / x;
    n = -n;
  }
  if (n === 0) {
    return 1;
  }

  if (n % 2 === 0) {
    let sub = myPow(x, n / 2);
    return sub * sub;
  }
  let sub = myPow(x, Math.floor(n / 2));
  return sub * sub * x;
};
