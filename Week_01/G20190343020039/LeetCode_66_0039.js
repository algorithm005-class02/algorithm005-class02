/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  let carry = 1;
  for (let i = digits.length - 1; i >= 0; i -= 1) {
    digits[i] += carry;
    carry = Math.floor(digits[i] / 10);
    digits[i] = digits[i] % 10;
  }
  if (carry > 0) { digits.unshift(carry); }
  return digits;
};
