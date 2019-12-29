#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#
from typing import List
# @lc code=start


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = [0] * n
        hill_diagonals = [0] * (2 * n - 1)
        dale_diagonals = [0] * (2 * n - 1)
        res = []

        def could_place(row, col):
            return not cols[col] and not hill_diagonals[row + col] and not dale_diagonals[row - col]

        def place_queen(row, col):
            cols[col] = 1
            hill_diagonals[row + col] = 1
            dale_diagonals[row - col] = 1

        def remove_queen(row, col):
            cols[col] = 0
            hill_diagonals[row + col] = 0
            dale_diagonals[row - col] = 0

        def backtrack(n, row, cur_stste):
            if row >= n:
                res.append(cur_stste)
                return
            for col in range(n):
                if could_place(row, col):
                    place_queen(row, col)
                    backtrack(n, row+1, cur_stste + [col])
                    remove_queen(row, col)

        def gr(n):
            board = []
            for s in res:
                for c in s:
                    board.append("." * c + "Q" + "." * (n-c-1))
            return [board[i:i+n] for i in range(0, len(board), n)]
        backtrack(n, 0, [])
        return gr(n)


# @lc code=end
print(Solution().solveNQueens(4))
