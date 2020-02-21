/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
  const charSet = generateCharSet();
  let wordSet = new Set(wordList);
  let visited = new Set();
  let result = [];
  let queue = [];
  visited.add(beginWord);
  queue.push([beginWord]);
  let foundResult = false;
  while (queue.length > 0 && !foundResult) {
    let levelSize = queue.length;
    let subVisited = new Set();
    while (levelSize-- > 0) {
      let path = queue.shift();
      let cur = path[path.length - 1];
      let curCharArray = cur.split("");
      for (let i = 0; i < curCharArray.length; i += 1) {
        let old = curCharArray[i];
        for (let j = 0; j < charSet.length; j += 1) {
          curCharArray[i] = charSet[j];
          let next = curCharArray.join("");
          if (!visited.has(next) && wordSet.has(next)) {
            let newpath = path.concat([next]);
            if (next === endWord) {
              foundResult = true;
              result.push(newpath);
            }
            queue.push(newpath);
            subVisited.add(next);
          }
        }
        curCharArray[i] = old;
      }
    }
    for (let elem of subVisited) {
      visited.add(elem);
    }
  }
  return result;
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

