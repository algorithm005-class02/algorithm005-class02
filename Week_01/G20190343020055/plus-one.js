/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {

    for (let i = digits.length - 1; i >= 0; i--) {

        let element = digits[i]
        element++
        if (element < 10) {
            digits[i] = element
            break
        }
        digits[i] = 0
        if (i == 0)  digits.unshift(1)
    }

    return digits
};