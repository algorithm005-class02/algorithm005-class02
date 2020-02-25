/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
  s = s.trim();
  let arr = s.split(/\s+/);
  return arr.reverse().join(' ');
};

