from heapq import heappop, heappush
from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n == 0 or grid[0][0] == 1:
            return -1
        target = (n - 1, n - 1)

        def get_neighbors(i, j):
            return [(x, y) for x, y in
                    [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1), (i + 1, j + 1), (i - 1, j - 1), (i + 1, j - 1),
                     (i - 1, j + 1)] if 0 <= x < n and 0 <= y < n and grid[x][y] == 0]

        queue = [(0, 0)]
        visitor = set([(0, 0)])
        cnt = 1
        while queue:
            nq = []
            for i, j in queue:
                if (i, j) == target:
                    return cnt
                for x, y in get_neighbors(i, j):
                    if (x, y) not in visitor:
                        visitor.add((x, y))
                        nq += [(x, y)]
            queue = nq
            cnt += 1
        return -1

    def shortestPathBinaryMatrixAH(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n == 0 or grid[0][0] == 1:
            return -1
        target = (n - 1, n - 1)
        heap = [(0, 1, 0, 0)]
        scores = {(0, 0): float("inf")}

        def get_neighbors(i, j):
            return [(x, y) for x, y in
                    [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1), (i + 1, j + 1), (i - 1, j - 1), (i + 1, j - 1),
                     (i - 1, j + 1)] if 0 <= x < n and 0 <= y < n and grid[x][y] == 0]

        while heap:
            f, g, i, j = heappop(heap)
            if (i, j) == target:
                return g
            if scores[(i, j)] < f:  # remove 重复的节点
                continue
            for x, y in get_neighbors(i, j):
                heuristic = max(abs(x - target[0]), abs(y - target[1]))
                ng = g + 1
                nf = heuristic + ng
                if nf < scores.get((x, y), float('inf')):
                    heappush(heap, (nf, ng, x, y))
                    scores[(x, y)] = nf

        return -1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().shortestPathBinaryMatrix(
    [[0, 0, 0, 0, 1, 1, 1, 1, 0], [0, 1, 1, 0, 0, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0, 0, 0, 0], [1, 1, 0, 0, 1, 0, 0, 1, 1],
     [0, 0, 1, 1, 1, 0, 1, 0, 1], [0, 1, 0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 1, 0, 1, 0, 0, 0], [0, 1, 0, 1, 1, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 1, 0, 1, 0]]))
