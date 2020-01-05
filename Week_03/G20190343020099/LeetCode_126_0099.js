/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
  let wordSet = new Set(wordList);
  if (!wordSet.has(endWord)) return [];
  wordSet.delete(beginWord);
  let beginSet = new Set([beginWord]);
  let map = new Map();
  let distance = 0;
  let minDistance = 0;
  while(beginSet.size) {
      if (beginSet.has(endWord)) break;
      let trySet = new Set();
      for (let word of beginSet) {
          let mapSet = new Set();
          for (let i = 0; i < word.length; i++) {
              for (let j = 0; j < 26; j++) {
                  let tryWord = word.slice(0, i) + String.fromCharCode(97 + j) + word.slice(i + 1);
                  if (!minDistance && tryWord === endWord) minDistance = distance + 1;
                  if (wordSet.has(tryWord)) {
                      trySet.add(tryWord);
                      mapSet.add(tryWord);
                  }
              }
          }
          map.set(word, mapSet);
      }
      distance++;
      for (let w of trySet) {
          wordSet.delete(w);
      }
      beginSet = trySet;
  }
  let ans = [];
  let path = [beginWord];
  dfs(beginWord, endWord, ans, path, map, minDistance, 0);
  return ans;
};

function dfs (beginWord, endWord, ans, path, map, minDistance, distance) {
  if (distance > minDistance) return ;
  if (beginWord === endWord) {
      ans.push(path.slice());
  }
  let words = map.get(beginWord)
  if (words) {
      for (let word of words) {
          path.push(word)
          dfs(word, endWord, ans, path, map, minDistance, distance + 1);
          path.pop();
      }
  }
}



if (1 > 2) console.log(1)
else console.log(2);
console.log(3)
