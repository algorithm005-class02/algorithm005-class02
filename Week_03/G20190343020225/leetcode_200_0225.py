'''
@Author: your name
@Date: 2019-12-28 20:28:22
@LastEditTime : 2019-12-28 21:13:09
@LastEditors  : Please set LastEditors
@Description: In User Settings Edit
@FilePath: \leetcode\200.岛屿数量.py
'''
#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
# 解法一:BFS
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dircetions = [(-1,0),(0,-1),(1,0),(0,1)]
        
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        counter = 0
        # 设置标志,记录改位置是否被遍历过
        mark = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                # 只有当是陆地,并且没有被遍历过才进入计数
                if grid[i][j] == '1' and mark[i][j] == False:
                    dp = deque()
                    dp.append((i,j))
                    mark[i][j] = True
                    while dp:
                        cur_x, cur_y = dp.popleft()
                        for direc in dircetions:
                            new_x, new_y = cur_x + direc[0], cur_y+direc[1]
                            if 0 <= new_x < m and 0 <= new_y < n and grid[new_x][new_y] == '1' and mark[new_x][new_y] == False:
                                dp.append((new_x, new_y))
                                mark[new_x][new_y] = True
                    # 记录有多少个连通的岛屿
                    counter += 1
        return counter

# @lc code=end

