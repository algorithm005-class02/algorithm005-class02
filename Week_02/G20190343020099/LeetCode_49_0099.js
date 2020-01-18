/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  let map = new Map();
  for (let i = 0; i < strs.length; i++) {
      let arrKey = Array.from({length : 26}).fill(0);
      let word = strs[i]
      for (let j = 0; j < word.length; j++) {
          let index = word.charCodeAt(j) - 'a'.charCodeAt(0);
          arrKey[index] += 1;
      }
      var key = arrKey.join('');
      if (map.has(key)) {
          map.get(key).push(word)
      } else {
          map.set(key, [word])
      }
  }
  return [...map.values()];
};