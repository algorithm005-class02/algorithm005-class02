# -*- encoding: utf-8 -*-
# Create by zq
# Create on 2020/1/16

class Solution1:
    """dfs"""
    def findCircleNum(self, M):
        res = 0
        visited = [0] * len(M)
        for i in range(len(M)):
            if visited[i] == 0:
                res += 1
                self.dfs(M, visited, i)
        return res

    def dfs(self, M, visited, i):
        for j in range(len(M[0])):
            if visited[j] == 0 and M[i][j] == 1:
                visited[j] = 1
                self.dfs(M, visited, j)

class Solution:
    """disjoint set"""
    def findCircleNum(self, M):
        n = len(M)
        p = [i for i in range(n)]
        for i in range(n):
            for j in range(i, n):
                if M[i][j] == 1 :
                    self._union(p, i, j)
        return len(set([self._parent(p, i) for i in range(n)]))

    def _parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:
            x = i; i = p[i]; p[x] = root
        return root
    def _union(self, p, i, j):
        p1 = self._parent(p, i)
        p2 = self._parent(p, j)
        p[p1] = p2






if __name__ == '__main__':
    M1 = [[1,1,0],
         [1,1,0],
         [0,0,1]]
    M2 = \
    [[1,1,0],
    [1,1,1],
    [0,1,1]]
    M3 = [[1, 0, 0, 1],
          [0, 1, 1, 0],
          [0, 1, 1, 1],
          [1, 0, 1, 1]]
    test = Solution()
    print(test.findCircleNum(M1))
    print(test.findCircleNum(M2))
    print(test.findCircleNum(M3))
