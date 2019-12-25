/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  const m = {
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z'],
  };
  function recursion(digits) {
    if (digits.length === 0) {
      return [];
    }
    if (digits.length === 1) {
      return m[digits];
    }
    let result = [];
    let val = m[digits[0]];
    let sub = recursion(digits.substring(1));
    for (let i = 0; i < val.length; i += 1) {
      for (let j = 0; j < sub.length; j += 1) {
        result.push(val[i] + sub[j]);
      }
    }
    return result;
  }
  return recursion(digits);
};
