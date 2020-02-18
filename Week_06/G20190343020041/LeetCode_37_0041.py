# 编写一个程序，通过已填充的空格来解决数独问题。
#
# 一个数独的解法需遵循如下规则：
#
#
# 数字 1-9 在每一行只能出现一次。
# 数字 1-9 在每一列只能出现一次。
# 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
#
#
# 空白格用 '.' 表示。
#
#
#
# 一个数独。
#
#
#
# 答案被标成红色。
#
# Note:
#
#
# 给定的数独序列只包含数字 1-9 和字符 '.' 。
# 你可以假设给定的数独只有唯一解。
# 给定数独永远是 9x9 形式的。
#
# Related Topics 哈希表 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        rows = [defaultdict(int) for _ in range(9)]
        columns = [defaultdict(int) for _ in range(9)]
        boxes = [defaultdict(int) for _ in range(9)]

        box_index = lambda row, col: (row // 3) * 3 + col // 3

        def valid(k, i, j):
            return (rows[i][k] + columns[j][k] + boxes[box_index(i, j)][k]) == 0

        def remove_number(i, j, k):
            board[i][j] = '.'
            rows[i][k] -= 1
            columns[j][k] -= 1
            boxes[box_index(i, j)][k] -= 1

        def place_number(i, j, k):
            board[i][j] = str(k)
            rows[i][k] += 1
            columns[j][k] += 1
            boxes[box_index(i, j)][k] += 1

        # 初始化 所有数据
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    place_number(i, j, int(board[i][j]))

        def dfs(d):
            if d == 81:
                return True
            i, j = d // 9, d % 9
            if board[i][j] != '.': return dfs(d + 1)
            for k in range(1, 10):
                if valid(k, i, j):
                    place_number(i, j, k)
                    if dfs(d + 1): return True
                    remove_number(i, j, k)
            return False

        dfs(0)
        return board


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().solveSudoku(
    [["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."],
     [".", "9", "8", ".", ".", ".", ".", "6", "."], ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
     ["4", ".", ".", "8", ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
     [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"],
     [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
)
