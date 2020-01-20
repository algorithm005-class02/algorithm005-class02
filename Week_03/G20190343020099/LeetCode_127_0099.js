/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  let wordListSet = new Set(wordList);
  let beginWordSet = new Set([beginWord]);
  let endWordSet = new Set([endWord]);
  if (!wordListSet.has(endWord)) return 0;
  let level = 1;
  while (beginWordSet.size) {
      let tryWordSet = new Set();
      for(word of beginWordSet) {
          for (let i = 0; i < word.length; i++) {
              for (let j = 0; j < 26; j++) {
                  let tryWord = word.slice(0, i) + String.fromCharCode(97 + j) + word.slice(i + 1);
                  if (endWordSet.has(tryWord)) return level + 1;
                  if (wordListSet.has(tryWord)) {
                      tryWordSet.add(tryWord);
                      wordListSet.delete(tryWord);
                  }
              }
          }
      }
      level++;
      beginWordSet = tryWordSet;
      if(beginWordSet.size > endWordSet.size){
          [beginWordSet,endWordSet] = [endWordSet,beginWordSet]
      }
  }
  return 0;
};