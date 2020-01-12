class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        #找规律，只能往下或往右走。每次走都记录状态
        #有四种方式,从左边走 i-1,从上边走j-1
        #第一种，i=0,j=0。dp[i][j] = grid[i][j]
        #第二种，i=0,j不等于0。只能从上边走 dp[i][j] = dp[i][j-1] + grid[i][j]
        #第三种，i不等于0，j=0。只能从左边走 dp[i][j] = dp[i-1][j] + grid[i][j]
        #第四种，i不等于0，j不等于0。dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
        
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if i == 0 and j == 0:
                    continue
                elif i == 0 and j > 0:
                    grid[i][j] += grid[i][j-1]
                elif i > 0 and j == 0:
                    grid[i][j] += grid[i-1][j]
                else:
                    grid[i][j] += min(grid[i-1][j],grid[i][j-1])
        return grid[-1][-1]