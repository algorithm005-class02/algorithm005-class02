#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
# N皇后解法，其实和电话号码字母组合是一个逻辑，用回溯算法求解
# 不同的是，字母组合是笛卡尔积式组合，N皇后如果没有限制攻击条件
# 也是N次笛卡尔积组合的一个回溯解法，那么在字母组合代码中只要把限制攻击
# 条件加上即得到N皇后的回溯解法

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def DFS(queen, xy_dif, xy_sum):
            q = len(queen)
            if q == n:
                output.append(queen)
                return
            for p in range(n):
                if p not in queen and p + q not in xy_sum and p - q not in xy_dif:
                    DFS(queen + [p], xy_dif + [p - q], xy_sum + [p + q])
        output = []
        DFS([], [], [])
        return [["."*i + "Q" + "."*(n - i - 1) for i in first] for first in output]

# @lc code=end

