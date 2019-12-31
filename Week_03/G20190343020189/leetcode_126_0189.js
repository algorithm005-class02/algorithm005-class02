// 126. Word Ladder II

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
  let wordDict = new Set(wordList);
  wordDict.add(beginWord);

  let wordToStep = {};
  let wordToNextWords = {};
  bfs(beginWord, endWord);

  let results = [];
  dfs([beginWord], results);

  return results;

  function bfs(beginWord, endWord) {
    let q = [endWord];
    let visited = new Set([endWord]);
    wordToStep[endWord] = 0;

    let reachedBeginWord = false;
    let index = 0;
    while (index < q.length) {
      let curWord = q[index];
      let curStep = wordToStep[curWord];
      if (curWord === beginWord) reachedBeginWord = true;

      for (let nextWord of getNextWords(wordToNextWords, wordDict, curWord)) {
        if (visited.has(nextWord)) continue;
        visited.add(nextWord);
        wordToStep[nextWord] = curStep + 1;
        if (!reachedBeginWord) q.push(nextWord);
      }

      index++;
    }
  }

  function getNextWords(wordToNextWords, wordDict, curWord) {
    if (wordToNextWords[curWord]) return wordToNextWords[curWord];

    const alphStr = 'abcdefghijklmnopqrstuvwxyz';
    let nextWords = [];
    for (let i = 0, j = curWord.length; i < j; i++) {
      let [left, letter, right] = [curWord.slice(0, i), curWord[i], curWord.slice(i + 1)];
      for (let char of alphStr) {
        if (letter === char) continue;
        const newWord = left + char + right;
        if (wordDict.has(newWord)) nextWords.push(newWord);
      }
    }

    wordToNextWords[curWord] = nextWords;
    return nextWords;
  }

  function dfs(base, results) {
    const curWord = base.slice(-1)[0];
    const curStep = wordToStep[curWord];
    if (curStep === 0) {
      results.push([...base]);
      return;
    }

    for (let nextWord of getNextWords(wordToNextWords, wordDict, curWord)) {
      const step = wordToStep[nextWord];
      if (step !== curStep - 1) continue;
      base.push(nextWord);
      dfs(base, results);
      base.pop();
    }
  }
};
