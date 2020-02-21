#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#
# https://leetcode-cn.com/problems/n-queens/description/
#
# algorithms
# Hard (66.77%)
# Likes:    322
# Dislikes: 0
# Total Accepted:    24.9K
# Total Submissions: 36.7K
# Testcase Example:  '4'
#
# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
# 
# 
# 
# 上图为 8 皇后问题的一种解法。
# 
# 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
# 
# 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
# 
# 示例:
# 
# 输入: 4
# 输出: [
# ⁠[".Q..",  // 解法 1
# ⁠ "...Q",
# ⁠ "Q...",
# ⁠ "..Q."],
# 
# ⁠["..Q.",  // 解法 2
# ⁠ "Q...",
# ⁠ "...Q",
# ⁠ ".Q.."]
# ]
# 解释: 4 皇后问题存在两个不同的解法。
# 
# 
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def DFS(queen, difs, sums):
            p = len(queen)
            if p == n:
                results.append(queen)
                return None
            for q in range(n):
                if q not in queen and (p - q) not in difs and (p + q) not in sums:
                    DFS(queen + [q], difs + [p - q], sums + [p + q])
        
        results = []
        DFS([], [], [])
        return [['.'*i + 'Q' + '.'*(n - i - 1) for i in res] for res in results]
        
# @lc code=end

