#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#
# https://leetcode-cn.com/problems/n-queens/description/
#
# algorithms
# Hard (66.80%)
# Likes:    290
# Dislikes: 0
# Total Accepted:    21.2K
# Total Submissions: 31.6K
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

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        # # 2019-12-26 22:14:53
        # # 9/9 cases passed (292 ms)
        # # Your runtime beats 6.2 % of python3 submissions
        # # Your memory usage beats 99.23 % of python3 submissions (13 MB)
        # ans = []

        # def helper(path: List[int]):
        #     if len(path) == n:  # T
        #         ans.append(path)
        #         return

        #     valid = [[True for _ in range(n)] for _ in range(n)]
        #     for i, v in enumerate(path):
        #         for c in range(n):
        #             valid[i][c] = False
        #         for r in range(n):
        #             valid[r][v] = False
        #         for r in range(n):
        #             c = r - (i - v)
        #             if c >= 0 and c < n:
        #                 valid[r][c] = False
        #             c = i + v - r
        #             if c >= 0 and c < n:
        #                 valid[r][c] = False

        #     r = len(path)
        #     for c in range(n):
        #         if valid[r][c]:
        #             helper(path + [c])

        # helper([])

        # solutions = []
        # for path in ans:
        #     solution = []
        #     for c in path:
        #         solution.append(''.join(['.' if e != c else 'Q' for e in range(n)]))
        #     solutions.append(solution)

        # return solutions

        # # 2019-12-26 22:56:20
        # # 9/9 cases passed (56 ms)
        # # Your runtime beats 96.67 % of python3 submissions
        # # Your memory usage beats 99.23 % of python3 submissions (13.1 MB)
        # ans = []
        # col_valid = [True for _ in range(n)]
        # diag_ne_valid, diag_se_valid = [True for _ in range(2 * n - 1)], [True for _ in range(2 * n - 1)]

        # def dfs(path: List[int], col_valid: List[bool],
        #         diag_ne_valid: List[bool], diag_se_valid: List[bool]):
        #     """
        #     path: path[i] ith row's col index
        #     """
        #     if len(path) == n:
        #         solution = [''.join(['Q' if i == c else '.' for i in range(n)]) for c in path]
        #         ans.append(solution)
        #         return
        #     r = len(path)
        #     for c in range(n):
        #         if col_valid[c] and diag_ne_valid[r + c] and diag_se_valid[r - c + n - 1]:
        #             path.append(c)
        #             col_valid[c], diag_ne_valid[r + c], diag_se_valid[r - c + n - 1] = False, False, False
        #             dfs(path, col_valid, diag_ne_valid, diag_se_valid)
        #             col_valid[c], diag_ne_valid[r + c], diag_se_valid[r - c + n - 1] = True, True, True
        #             path.pop()

        # dfs([], col_valid, diag_ne_valid, diag_se_valid)
        # return ans

        # 2019-12-28 22:32:21
        # 状态变量作为全局变量
        ans = []
        col_valid = [True for _ in range(n)]
        diag_ne_valid, diag_se_valid = [True for _ in range(2 * n - 1)], [True for _ in range(2 * n - 1)]

        def dfs(path: List[int]):
            """
            path: path[i] ith row's col index
            """
            if len(path) == n:
                solution = [''.join(['Q' if i == c else '.' for i in range(n)]) for c in path]
                ans.append(solution)
                return
            r = len(path)
            for c in range(n):
                if col_valid[c] and diag_ne_valid[r + c] and diag_se_valid[r - c + n - 1]:
                    path.append(c)
                    col_valid[c], diag_ne_valid[r + c], diag_se_valid[r - c + n - 1] = False, False, False
                    dfs(path)
                    col_valid[c], diag_ne_valid[r + c], diag_se_valid[r - c + n - 1] = True, True, True
                    path.pop()

        dfs([])
        return ans

# @lc code=end


def main():
    print(Solution().solveNQueens(4))


if __name__ == '__main__':
    main()
