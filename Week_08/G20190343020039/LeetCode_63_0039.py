from typing import List

class Solution:
  def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
    rows = len(obstacleGrid)
    cols = len(obstacleGrid[0])
    dp = [[0 for _ in range(cols)] for _ in range(rows)]

    if obstacleGrid[rows-1][cols-1] == 0:
      dp[rows-1][cols-1] = 1

    for row in range(rows-2, -1, -1):
      if obstacleGrid[row][cols-1] == 0 and dp[row+1][cols-1] == 1:
        dp[row][cols-1] = 1

    for col in range(cols-2, -1, -1):
      if obstacleGrid[rows-1][col] == 0 and dp[rows-1][col+1] == 1:
        dp[rows-1][col] = 1

    for row in range(rows-2, -1, -1):
      for col in range(cols-2, -1, -1):
        if obstacleGrid[row][col] == 1:
          dp[row][col] = 0
        else:
          dp[row][col] = dp[row+1][col] + dp[row][col+1]

    return dp[0][0]


s = Solution()
result = s.uniquePathsWithObstacles([[0,0,0],[0,1,0],[0,0,0]])
print(result)

