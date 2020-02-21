# 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
#
# 例如，给定三角形：
#
# [
#     [2],
#    [3,4],
#   [6,5,7],
#  [4,1,8,3]
# ]
#
#
# 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
#
# 说明：
#
# 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i + 1][j], dp[i + 1][j + 1])
        return dp[0][0]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]))
