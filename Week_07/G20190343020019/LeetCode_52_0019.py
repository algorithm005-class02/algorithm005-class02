#
# @lc app=leetcode.cn id=52 lang=python3
#
# [52] N皇后 II
#

# @lc code=start
class Solution:
    def totalNQueens(self, n: int) -> int:
        # 位运算 + DFS   100% 55%
        self.ans = 0
        self.dfs(n, 0, 0, 0, 0)
        return self.ans
        
    def dfs(self, n, row, cols, pie, na):
        if row >= n:
            self.ans += 1
            return
        bits = (~(cols | pie | na)) & ((1 << n) - 1)
        while bits:
            p = bits & (-bits)
            bits = bits & (bits - 1)
            self.dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
        
        
# @lc code=end

