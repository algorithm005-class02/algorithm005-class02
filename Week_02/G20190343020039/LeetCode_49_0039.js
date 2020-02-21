/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  const m = {};
  for (let i = 0; i < strs.length; i += 1) {
    const str = strs[i];
    const key = str.split("").sort().join("");
    if (key in m) {
      m[key].push(str);
    } else {
      m[key] = [str];
    }
  }

  const result = [];
  for (let key in m) {
    result.push(m[key]);
  }
  return result;
};
