class Solution:
  def findCircleNum(self, M: List[List[int]]) -> int:
    if not M: return 0
    n = len(M)
    p = [i for i in range(n)]

    for i in range(n):
      for j in range(n):
        if M[i][j] == 1:
          self.union(p, i, j)

    return len(set([self.parent(p, i) for i in range(n)]))

  def union(self, p, i, j):
    p1 = self.parent(p, i)
    p2 = self.parent(p, j)
    p[p1] = p2

  def parent(self, p, i):
    root = i
    while p[root] != root:
      root = p[root]
    while p[i] != i:
      x = i; i = p[i]; p[x] = root
    return root

