#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    # 递归的入口
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n < 1: return []

        self.result = []
        self.cols = set()
        self.pie = set()
        self.na = set()
        self.DFS(n, 0, [])
        return self.generate_result(n)

    def DFS(self, n, row, cur_state):
        # 终止条件：当row到棋盘的最后一层时，所有皇后排列完毕，将所有结果加到结果中
        if row >= n:
            self.result.append(cur_state)
            return 
        # 依次判断当前层每个对角线是否满足皇后唯一
        for col in range(n):
            if col in self.cols or row + col in self.pie or row - col in self.na:
                continue
            # 将皇后放在当前位置，并记录对角线常数
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)
            # 进入下层递归
            self.DFS(n, row + 1, cur_state + [col])

            # 清除递归当前层添加的内容，防止影响上层
            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(row - col)

    # 棋盘的输出
    def generate_result(self, n):
        board = []
        for res in self.result:
            for i in res:
                board.append("." * i + "Q" + "." * (n - i - 1))

        return [board[i: i + n] for i in range(0, len(board), n)]
# @lc code=end

