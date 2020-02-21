/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  return Math.floor(MySqrt(x, 0.01));
};

function MySqrt(x, precision) {
  if (x === 0 || x === 1) {
    return x;
  }

  let left = 0;
  let right = x;
  while (left <= right) {
    let mid = (left + right) / 2;
    let cur = mid * mid;
    if (cur - x >= -precision && cur - x <= precision) {
      return mid;
    } else if (cur > x) {
      right = mid;
    } else {
      left = mid;
    }
  }
  return null;
}

