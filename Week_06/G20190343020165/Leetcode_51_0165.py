class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        #全排列，剪枝
        #每排只能放一个皇后，（0，0）位置开始放，接着放第二排，满足条件的话接着往下放，不满足条件则回退到上一列。
        #这里的条件可以统一分成四个条件
        #1.不能同一排
        #2.不能同一列
        #3.正斜不能有皇后，正斜可以用x的坐标+y的坐标，恒等于一个固定数字
        #4.反斜不能有皇后，反斜x-y的值，恒等于一个固定数字
        #正斜和反斜计算的固定数字只要存在，就必定代表有皇后，需要剪枝
        #利用集合存储当前排列放置皇后的位置，进行剪枝
        res = []
        if n == 0:
            return res
        def backtracking(nums, row, col, master ,slave):
            if row == n:
                board = self._coverttoborad(stack, n)
                res.append(board)
                return
            for i in range(n):
                if i not in col and row + i not in master and row -i not in slave:
                    stack.append(nums[i])
                    master.add(row + i)
                    slave.add(row - i)
                    col.add(i)
                    backtracking(nums, row + 1, col, master, slave)
                    stack.pop()
                    master.remove(row + i)
                    slave.remove(row - i)
                    col.remove(i)
        col = set()
        master = set()
        slave = set()
        stack = []
        nums = [i for i in range(n)]

        backtracking(nums, 0, col, master ,slave)

        return res
    def _coverttoborad(self, stack, n):
        return ["." * stack[i] + "Q" + "." * (n - stack[i] - 1) for i in range(n)]

        