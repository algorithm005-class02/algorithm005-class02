#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#
# https://leetcode-cn.com/problems/number-of-islands/description/
#
# algorithms
# Medium (46.40%)
# Likes:    319
# Dislikes: 0
# Total Accepted:    46.4K
# Total Submissions: 99.9K
# Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
#
# 给定一个由 '1'（陆地）和
# '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
#
# 示例 1:
#
# 输入:
# 11110
# 11010
# 11000
# 00000
#
# 输出: 1
#
#
# 示例 2:
#
# 输入:
# 11000
# 11000
# 00100
# 00011
#
# 输出: 3
#
#
#

# @lc code=start

from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        # # dfs, 重复问题, step. 合适更新ans; 何时触发step
        # # 2020-01-01 17:56:20
        # if not grid: return 0
        # m, n = len(grid), len(grid[0])
        # is_visited = [[False] * n for r in range(m)]

        # def dfs(i, j):
        #     if i < 0 or i >= m or j < 0 or j >= n or not (grid[i][j] == '1' and not is_visited[i][j]):
        #         return
        #     is_visited[i][j] = True
        #     dfs(i + 1, j)
        #     dfs(i - 1, j)
        #     dfs(i, j - 1)
        #     dfs(i, j + 1)

        # ans = 0
        # for i in range(m):
        #     for j in range(n):
        #         if grid[i][j] == '1' and not is_visited[i][j]:
        #             dfs(i, j)
        #             ans += 1
        # return ans
        class UnionFind():
            def __init__(self, n):
                self.count = n
                self.parent = [i for i in range(n)]

            def union(self, i, j):
                i_parent = self.find(i)
                j_parent = self.find(j)
                if i_parent == j_parent: return
                self.parent[i_parent] = j_parent
                self.count -= 1

            def find(self, i):
                root = i
                while root != self.parent[root]:
                    root = self.parent[root]
                while i != self.parent[i]:
                    tmp = self.parent[i]
                    self.parent[i] = root
                    i = tmp
                return root

                # while i != self.parent[i]:
                #     self.parent[i] = self.parent[self.parent[i]]  # 压缩
                #     i = self.parent[i]
                # return i

        if not grid: return 0
        m, n = len(grid), len(grid[0])
        water_node = n * m
        uf = UnionFind(m * n + 1)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0':
                    uf.union(i * n + j, water_node)
                else:
                    for dx, dy in [(0, -1), (-1, 0)]:
                        if i + dx >= 0 and j + dy >= 0 and grid[i + dx][j + dy] == '1':
                            uf.union((i + dx) * n + (j + dy), i * n + j)
        return uf.count - 1


# @lc code=end
