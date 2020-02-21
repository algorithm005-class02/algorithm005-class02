#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#

# @lc code=start
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # 动态规划   47%  53%
        m, n = len(grid), grid and len(grid[0])
        if not m or not n:
            return 0
        # 初始化第一行数据
        for i in range(1, n):
            grid[0][i] += grid[0][i - 1]
        # 逐层更新状态数据
        for i in range(1, m):
            for j in range(0, n):
                if j == 0:
                    grid[i][j] += grid[i - 1][j]
                else:
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        return grid[m - 1][n - 1]

        
# @lc code=end

