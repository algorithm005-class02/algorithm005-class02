// 17. Letter Combinations of a Phone Number

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  // aware of & confirm the result of the edge case
  if (!digits) return [];

  const digToLetter = {
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z'],
  };

  // normal DFS
  let results = [];
  dfs(digToLetter, digits, 0, '', results);

  return results;

  function dfs(digToLetter, digits, index, str, results) {
    if (index === digits.length) {
      results.push(str);
      return;
    }

    const digit = digits[index];
    for (let letter of digToLetter[digit]) {
      dfs(digToLetter, digits, index + 1, str + letter, results);
    }
  }

  // generator as interator
  let results = [];
  for (let str of dfs(digToLetter, digits, 0, '', results)) {
    results.push(str);
  }

  return results;

  function* dfs(digToLetter, digits, index, str, results) {
    if (index === digits.length) {
      yield str;
      return;
    }

    const digit = digits[index];
    for (let letter of digToLetter[digit]) {
      yield* dfs(digToLetter, digits, index + 1, str + letter, results);
    }
  }
};
