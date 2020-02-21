#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#

# @lc code=start
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M: return 0
        n = len(M)
        p = [i for i in range(n)]
        for i in range(n):
            for j in range(i, n):
                if M[i][j] == 1:
                    self._union(p, i, j)
        return len(set([self._find(p, i) for i in range(n)]))
        # return len(set(p))

    def _union(self, p, i, j):
        p1 = self._find(p, i)
        p2 = self._find(p, j)
        p[p1] = p2

    def _find(self, p, i):
        root = i
        while root != p[root]:
            root = p[root]
        while i != p[i]:
            x = i
            i = p[i]
            p[x] = root
        return root


        
# @lc code=end

