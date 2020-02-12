/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  if (!n) return 0;
  let count = 0;
  while (n != 0) {
      n &= (n - 1);
      count++;
  }
  return count;
};