# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
#  [2,4],
#  [3,4],
#  [2,3],
#  [1,2],
#  [1,3],
#  [1,4],
# ]
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        def dfs(n, k, s, status, res):
            if len(status) == k:
                res.append(status[:])
                return
            for i in range(s, n + 1):
                status.append(i)
                dfs(n, k, i + 1, status, res)
                status.pop()

        dfs(n, k, 1, [], res)
        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().combine(4, 2)
