/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
  if (start === end) { return 0; }
  const charSet = ['A', 'C', 'G', 'T'];
  const bankSet = new Set(bank);
  let level = 0;
  const queue = [];
  const visited = new Set();
  queue.push(start);
  visited.add(start);
  while (queue.length > 0) {
    let levelSize = queue.length;
    while (levelSize-- > 0) {
      let cur = queue.shift();
      if (cur === end) {
        return level;
      }
      let curCharArray = cur.split("");
      for (let i = 0; i < curCharArray.length; i += 1) {
        let old = curCharArray[i];
        for (let j = 0; j < charSet.length; j += 1) {
          curCharArray[i] = charSet[j];
          let next = curCharArray.join("");
          if (!visited.has(next) && bankSet.has(next)) {
            visited.add(next);
            queue.push(next);
          }
        }
        curCharArray[i] = old;
      }
    }
    level += 1;
  }
  return -1;
};
