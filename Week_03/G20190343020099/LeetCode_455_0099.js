/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);
  let count = 0;
  for (let i = 0, j = 0; i < g.length && j < s.length;) {
      if (s[j] >= g[i]) {
          count++;
          i++;
          j++;
      } else {
          j++;
      }
  }
  return count;
};