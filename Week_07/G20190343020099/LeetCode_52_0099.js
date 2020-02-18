/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {
  let ans = 0;
  let size = (1 << n) - 1;
  function dfs(cols, pie, na) {
      if (cols == size) ans++;
      let pos = ~(cols | pie | na) & size;
      while (pos != 0) {
          let p = pos & (-pos);
          dfs(cols | p, (pie | p) << 1, (na | p) >> 1);
          pos &= (pos - 1);
      }
  }
  dfs(0, 0, 0);
  return ans;
};