/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  if (!digits || digits.length < 1) return [];

  let ans = [];
  helper(digits, ans, '', 0);
  return ans;
};
let map = {
      '2' : 'abc',
      '3' : 'def',
      '4' : 'ghi',
      '5' : 'jkl',
      '6' : 'mno',
      '7' : 'pqrs',
      '8' : 'tuv',
      '9' : 'wxyz'
  }

function helper (digits, ans, s, idx) {
  if (idx >= digits.length) {
      ans.push(s);
      return ;
  }

  let key = digits.charAt(idx) +'';
  let letters = map[key];
  for (let j = 0; j < letters.length; j++) {
      helper(digits, ans, s + letters[j], idx + 1);
  }

}