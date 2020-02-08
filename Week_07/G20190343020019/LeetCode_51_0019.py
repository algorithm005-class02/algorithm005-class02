#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # 回溯法  48%  99%
        # ans = []
        # def dfs(queens, pie, na):
        #     row = len(queens)
        #     if row >= n:
        #         ans.append(queens)
        #         return None
        #     for col in range(n):
        #         if col in queens or (col + row) in pie or (col - row) in na:
        #             continue
        #         dfs(queens + [col], pie + [col + row], na + [col - row])
        # dfs([], [], [])
        # return [['.' * i + 'Q' + '.' * (n - i - 1) for i in arr] for arr in ans]

        # 98%  99%  ...
        ans = []
        def dfs(cols, pie, na):
            row = len(cols)
            if row >= n:
                ans.append(cols)
                return
            for col in range(n):
                if col in cols or (row + col) in pie or (row - col) in na:
                    continue
                dfs(cols + [col], pie + [row + col], na + [row - col])
        dfs([], [], [])
        return [['.' * i + 'Q' + '.' * (n - i - 1) for i in arr] for arr in ans]
        
# @lc code=end

