/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
  if (num < 2) { return true; }
  let left = 2;
  let right = Math.floor(num / 2);
  while (left <= right) {
    let mid = left + Math.floor((right - left) / 2);
    let guessSquared = mid * mid;
    if (guessSquared === num) {
      return true;
    } else if (guessSquared < num) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return false;
};
