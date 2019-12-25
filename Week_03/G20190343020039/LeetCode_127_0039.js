/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  const charSet = generateCharSet();
  let wordSet = new Set(wordList);
  let visited = new Set();
  let queue = [];
  visited.add(beginWord);
  queue.push(beginWord);
  let level = 0;
  while (queue.length > 0) {
    let levelSize = queue.length;
    while (levelSize-- > 0) {
      let cur = queue.shift();
      if (cur === endWord) {
        return level + 1;
      }
      let curCharArray = cur.split("");
      for (let i = 0; i < curCharArray.length; i += 1) {
        let old = curCharArray[i];
        for (let j = 0; j < charSet.length; j += 1) {
          curCharArray[i] = charSet[j];
          let next = curCharArray.join("");
          if (!visited.has(next) && wordSet.has(next)) {
            visited.add(next);
            queue.push(next);
          }
        }
        curCharArray[i] = old;
      }
    }
    level += 1;
  }
  return 0;
};

function generateCharSet() {
  let charSet = [];
  let start = 'a'.charCodeAt(0);
  let end = start + 26;
  for (let i = start; i < end; i += 1) {
    charSet.push(String.fromCharCode(i));
  }
  return charSet;
}


const beginWord = "hit"
const endWord = "cog"
const wordList = ["hot","dot","dog","lot","log","cog"]

const result = ladderLength(beginWord, endWord, wordList);
console.log(result);

