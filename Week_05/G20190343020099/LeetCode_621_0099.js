/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function(tasks, n) {
  if (!tasks.length) return 0;
  if (n === 0) return tasks.length;
  let countNum = Array(26).fill(0);
  for (let letter of tasks) {
      countNum[letter.charCodeAt() - "A".charCodeAt()]++
  }
  countNum.sort((a, b) => (b - a));
  let maxLetterCount = countNum[0];
  let idleTime = (maxLetterCount - 1) * n;
  for (let i = 1; i < countNum.length; i++) {
      if (countNum[i] > 0) {
          let count = Math.min(countNum[i], maxLetterCount - 1);
          idleTime -= count;
      }
  }
  return idleTime > 0 ? tasks.length + idleTime : tasks.length;
};