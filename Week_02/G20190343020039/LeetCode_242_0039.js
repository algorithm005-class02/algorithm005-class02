/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) { return false; }
  const m = new Array(26).fill(0);
  for (let i = 0; i < s.length; i += 1) {
    m[s.charCodeAt(i) - 97]++;
    m[t.charCodeAt(i) - 97]--;
  }
  return m.filter(e => e > 0).length === 0;
};
