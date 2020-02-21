#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#
# https://leetcode-cn.com/problems/friend-circles/description/
#
# algorithms
# Medium (53.87%)
# Likes:    174
# Dislikes: 0
# Total Accepted:    21.9K
# Total Submissions: 40.4K
# Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
#
# 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C
# 的朋友。所谓的朋友圈，是指所有朋友的集合。
#
# 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
# 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
#
# 示例 1:
#
#
# 输入:
# [[1,1,0],
# ⁠[1,1,0],
# ⁠[0,0,1]]
# 输出: 2
# 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
# 第2个学生自己在一个朋友圈。所以返回2。
#
#
# 示例 2:
#
#
# 输入:
# [[1,1,0],
# ⁠[1,1,1],
# ⁠[0,1,1]]
# 输出: 1
# 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
#
#
# 注意：
#
#
# N 在[1,200]的范围内。
# 对于所有学生，有M[i][i] = 1。
# 如果有M[i][j] = 1，则有M[j][i] = 1。
#
#
#

# @lc code=start


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:

        # # O(N^2 N)
        # # 113/113 cases passed (56 ms)
        # # Your runtime beats 99.42 % of python3 submissions
        # # Your memory usage beats 74.25 % of python3 submissions (13.3 MB)
        # class UnionFind():
        #     def __init__(self, n):
        #         self.count = n
        #         self.parent = [i for i in range(n)]

        #     def union(self, i, j):
        #         i_parent = self.find(i)
        #         j_parent = self.find(j)
        #         if i_parent == j_parent: return
        #         self.parent[i_parent] = j_parent
        #         self.count -= 1

        #     def find(self, i):
        #         while i != self.parent[i]:
        #             self.parent[i] = self.parent[self.parent[i]]  # 压缩
        #             i = self.parent[i]
        #         return i

        # n = len(M)
        # uf = UnionFind(n)
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         if M[i][j] == 1: uf.union(i, j)
        # return uf.count

        # DFS: 和200搜索不同，需进一步整理
        # 113/113 cases passed (48 ms)
        # Your runtime beats 99.71 % of python3 submissions
        # Your memory usage beats 71.08 % of python3 submissions (13.5 MB)
        ans = 0
        n = len(M)
        is_visited = [False] * n

        def dfs(i):             # TUPR
            if is_visited[i]: return
            is_visited[i] = True
            for j, is_friend in enumerate(M[i]):
                if is_friend and not is_visited[j]:
                    dfs(j)

        for i in range(n):
            if not is_visited[i]:  # 首次访问岛屿上的某块陆地
                dfs(i)
                ans += 1
        return ans

# @lc code=end
