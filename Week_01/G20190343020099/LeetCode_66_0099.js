/**
 * 解法一
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let carry = 0;
    for (let i = digits.length - 1; i >= 0; i--) {
        let sum;
        if (i === digits.length - 1) {
            sum = digits[i] + 1 + carry;
        }else {
            sum = digits[i] + carry;
        }
        carry = Math.trunc(sum / 10);
        mod = sum % 10;
        digits[i] = mod;
    }
    if (carry != 0) digits.unshift(carry);
    return digits;
};

/**
 * 解法二
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            ++digits[i];
            return digits
        }
        digits[i] = 0;
    }
    digits.unshift(1);
    return digits;
};