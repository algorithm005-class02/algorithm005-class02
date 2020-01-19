class Solution(object):
    def findCircleNum(self, M):
        parent = [-1] * len(M)
        rank = dict()
        for i in range(len(M)):
            for j in range(i):
                if M[i][j] == 1:
                    self.union(i, j, parent, rank)
        ans = 0
        for i in parent:
            if i == -1:
                ans += 1
        return ans

    def findRoot(self, num, parent):
        while parent[num] != -1:
            num = parent[num]
        return num

    def union(self, x, y, parent, rank):
        if x == y:
            return
        x = self.findRoot(x, parent)
        y = self.findRoot(y, parent)
        rank_x = rank[x] if x in rank else 0
        rank_y = rank[y] if y in rank else 0
        if x == y:
            return
        if rank_x > rank_y:
            parent[y] = x
        elif rank_x < rank_y:
            parent[x] = y
        else:
            parent[x] = y
            rank[y] = 1