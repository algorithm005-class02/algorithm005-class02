#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#
from typing import List


# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []

        def dfs(n, queens, hill_diagonals, dale_diagonals):
            row = len(queens)
            if row >= n:
                res.append(queens)
                return
            for col in range(n):
                if col not in queens and row + col not in hill_diagonals and row - col not in dale_diagonals:
                    dfs(n, queens + [col], hill_diagonals + [row + col], dale_diagonals + [row - col])

        dfs(n, [], [], [])
        return [[["." * i + "Q" + "." * (n - i - 1)] for i in r] for r in res]


# @lc code=end
print(Solution().solveNQueens(4))
