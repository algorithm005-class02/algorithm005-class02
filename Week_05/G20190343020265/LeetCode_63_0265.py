#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
# 解法一，开辟一个二维数组存放动态规划的过程值，然后通过两个for循环用递推公式更新递推值
# 因为有障碍物，所以第一个值/第一行/第一列都要先做一次判断和赋值，有障碍物则为0且后续均为0
# 然后在用递推公式更新时，也需要对是否有障碍物进行判断和赋值，最终输出递推最终值。

# @lc code=start
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if not obstacleGrid:
            return 0
        r, c = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0]*c for _ in range(r)]
        dp[0][0] = 1 if obstacleGrid[0][0] != 1 else 0
        if dp[0][0] == 0:
            return 0
        for i in range(1, r):
            if obstacleGrid[i][0] != 1:
                dp[i][0] = dp[i-1][0]
        for j in range(1, c):
            if obstacleGrid[0][j] != 1:
                dp[0][j] = dp[0][j-1]
        for i in range(1, r):
            for j in range(1, c):
                if obstacleGrid[i][j] != 1:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]        
        
# @lc code=end

