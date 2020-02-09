/**
 * @param {number[]} stones
 * @return {boolean}
 */
var canCross = function(stones) {
  let map = new Map();
  for (i of stones) map.set(i, new Set());
  map.get(0).add(0);
  for (let i = 0; i < stones.length; i++) {
      for (let j of map.get(stones[i])) {
          for (let jump = j - 1; jump <= j + 1; jump++) {
              if (jump < 0) continue;
              if (map.has(stones[i] + jump)) {
                  map.get(stones[i] + jump).add(jump);
              }
          }
      }
  }
  return map.get(stones[stones.length - 1]).size > 0;
};