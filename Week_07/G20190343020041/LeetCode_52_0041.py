# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#
#
#
# 上图为 8 皇后问题的一种解法。
#
# 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
#
# 示例:
#
# 输入: 4
# 输出: 2
# 解释: 4 皇后问题存在如下两个不同的解法。
# [
#  [".Q..",  // 解法 1
#   "...Q",
#   "Q...",
#   "..Q."],
#
#  ["..Q.",  // 解法 2
#   "Q...",
#   "...Q",
#   ".Q.."]
# ]
#
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalNQueens(self, n: int) -> int:
        self.count = 0
        MASK = (1 << n) - 1

        def dfs(n, row, cols, hill_diagonal, dale_diagonal):
            print()
            print("-------")

            if row >= n:
                self.count += 1
                return
            bits = ~(cols | hill_diagonal | dale_diagonal) & MASK  # 获取所有可用元素 1代表可用
            print("row:", row)
            print("cols:", get_bin(cols, 4))
            print("hill_diagonal:", get_bin(hill_diagonal, 4))
            print("dale_diagonal:", get_bin(dale_diagonal, 4))
            print("bits", get_bin(bits, 4))
            while bits:
                bit = bits & -bits  # 得到最后一个1
                bits ^= bit
                dfs(n, row + 1, cols | bit, (hill_diagonal | bit) << 1, (dale_diagonal | bit) >> 1)

        dfs(n, 0, 0, 0, 0)
        return self.count


get_bin = lambda x, n: format(x, 'b').zfill(n)

# leetcode submit region end(Prohibit modification and deletion)
print(Solution().totalNQueens(4))
