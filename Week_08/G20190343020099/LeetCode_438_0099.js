/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
  if (!s || !p) return [];
  let need = {}, window = {}, cnt = 0, ans = [];
  [...p].forEach(c => need[c] ? need[c]++ : need[c] = 1);
  let l = 0, r = 0, pLen = Object.keys(need).length;
  while (r < s.length) {
      let c1 = s[r];
      if (need[c1]) {
          window[c1] ? window[c1]++ : window[c1] = 1;
          if (window[c1] === need[c1]) cnt++;
      }
      r++;
      while (cnt === pLen) {
          let c2 = s[l];
          if (p.length === (r - l)) ans.push(l);
          if (need[c2]) {
              window[c2]--;
              if(window[c2] < need[c2]) cnt--;
          }
          l++;
      }
  }
  return ans;
};