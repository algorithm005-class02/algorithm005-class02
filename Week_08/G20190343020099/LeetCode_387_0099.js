/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  let map = {}
  for (let c of s) {
      if (!map[c]) {
          map[c] = 1;
      } else {
          map[c] += 1;
      }
  }
  for (let i = 0; i < s.length; i++) {
      if (map[s[i]] < 2) return i
  }
  return -1;
};