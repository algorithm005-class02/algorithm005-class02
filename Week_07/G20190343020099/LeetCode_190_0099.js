/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  let res
  for (let i = 31; i >= 0; i--) {
      res = res | ((n >> (31 - i)) & 1) << i
  }
  return res >>> 0;
};