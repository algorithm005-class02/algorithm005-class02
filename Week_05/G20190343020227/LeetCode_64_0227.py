class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #当前节点的最小路径，就是当前路径+min（上边 or 左边）的和
        if not grid:
            return 0
        m = len(grid)    #列
        n = len(grid[0]) #行

        for i in range(1,n):
            grid[0][i] += grid[0][i-1] #初始化第一行
        for j in range(1,m):
            grid[j][0] += grid[j-1][0] #初始化第一列
        for x in range(1,m):
            for y in range(1,n):
                grid[x][y] += min(grid[x-1][y],grid[x][y-1]) #取行或者列里最小的那个
        return grid[-1][-1] #返回[-1][-1]，也就是最小路径