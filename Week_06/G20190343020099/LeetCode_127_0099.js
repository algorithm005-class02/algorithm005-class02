/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  let wordSet = new Set(wordList);
  if (!wordSet.has(endWord)) return 0;
  let beginSet = new Set([beginWord]);
  let endSet = new Set([endWord]);
  let level = 1;
  while (beginSet.size) {
      let trySet = new Set();
      for (let word of beginSet) {
          for (let i = 0; i < word.length; i++) {
              for (let j = 0; j < 26; j++) {
                  let tryWord = word.slice(0, i) + String.fromCharCode(j + 97) + word.slice(i + 1);
                  if (endSet.has(tryWord)) {
                      return level + 1;
                  }
                  if (wordSet.has(tryWord)) {
                      trySet.add(tryWord);
                  }
              }
          }
      }
      level++;
      for (let w of trySet) {
          wordSet.delete(w);
      }
      beginSet = trySet;
      if (beginSet.size > endSet.size) [beginSet, endSet] = [endSet, beginSet];
  }
  return 0;
};