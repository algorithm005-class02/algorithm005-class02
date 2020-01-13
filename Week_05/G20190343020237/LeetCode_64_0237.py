#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#
# https://leetcode-cn.com/problems/minimum-path-sum/description/
#
# algorithms
# Medium (63.89%)
# Likes:    357
# Dislikes: 0
# Total Accepted:    50.9K
# Total Submissions: 79.6K
# Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
#
# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。
#
# 示例:
#
# 输入:
# [
# [1,3,1],
# ⁠ [1,5,1],
# ⁠ [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
#
#
#

# @lc code=start


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # # 暴力: DFS + 剪枝
        # # 最小和，和路径无关系，BFS/DFS均可
        # # 没有剪枝: TLE @20/61
        # # 有剪枝: TLE @60/61
        # nrow, ncol = len(grid), len(grid[0])

        # ans = [float('inf')]

        # distance = [[float('inf')] * ncol for _ in range(nrow)]

        # def dfs(i, j, cumsum):
        #     if i == nrow - 1 and j == ncol - 1:  # Terminal
        #         ans[0] = min(ans[0], cumsum)
        #         return
        #     if i >= nrow or j >= ncol: return

        #     if cumsum >= distance[i][j]:
        #         return

        #     distance[i][j] = cumsum

        #     if i + 1 < nrow: dfs(i + 1, j, cumsum + grid[i + 1][j])
        #     if j + 1 < ncol: dfs(i, j + 1, cumsum + grid[i][j + 1])

        # dfs(0, 0, grid[0][0])
        # return ans[0]

        # DP: dp[i, j] = min(dp[i-1, j] + dp[i, j-1]) + grid[i, j]
        # O(M*N), O(M*N)
        nrow, ncol = len(grid), len(grid[0])
        dp = [[None] * ncol for _ in range(nrow)]
        dp[0][0] = grid[0][0]
        for i in range(1, nrow): dp[i][0] = dp[i - 1][0] + grid[i][0]
        for j in range(1, ncol): dp[0][j] = dp[0][j - 1] + grid[0][j]
        for i in range(1, nrow):
            for j in range(1, ncol):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[-1][-1]

        # @lc code=end
