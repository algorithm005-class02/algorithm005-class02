# -*- encoding: utf-8 -*-
# Create on 2020/2/15

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        # 初始化第一行和第一列
        if obstacleGrid[0][0] == 0:
            obstacleGrid[0][0] = 1
        elif obstacleGrid[0][0] == 1:
            return 0
        for i in range(1, n):
            if obstacleGrid[0][i] == 1:
                obstacleGrid[0][i] = 0
            elif obstacleGrid[0][i] == 0:
                obstacleGrid[0][i] = obstacleGrid[0][i-1]
        for i in range(1, m):
            if obstacleGrid[i][0] == 1:
                obstacleGrid[i][0] = 0
            elif obstacleGrid[i][0] == 0:
                obstacleGrid[i][0] = obstacleGrid[i-1][0]
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    obstacleGrid[i][j] = 0
                elif obstacleGrid[i][j] == 0:
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
        return obstacleGrid[-1][-1]

if __name__ == '__main__':
    test = Solution()
    print(test.uniquePathsWithObstacles([
  [0,0,0],
  [0,1,0],
  [0,0,0]
]))

