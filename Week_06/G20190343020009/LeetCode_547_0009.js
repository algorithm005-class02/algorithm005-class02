/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function (M) {
  let n = M.length;
  if (n == 0) {
    return 0;
  }
  let count = n;
  let rank = new Array(n);
  let find = (p) => {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }
  let union = (p, q) => {
    let rootP = find(p);
    let rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }
    if (rank[rootP] > rank[rootQ]) {
      parent[rootQ] = rootP;
    } else if (rank[rootP] < rank[rootQ]) {
      parent[rootP] = rootQ;
    } else {
      parent[rootQ] = rootP;
      rank[rootP]++;
    }
    count--;
  }
  let parent = new Array(n);
  for (let i = 0; i < n; i++) {
    parent[i] = i;
    rank[i] = 1;
  }
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (M[i][j] == 1) {
        union(i, j);
      }
    }
  }
  return count;
}