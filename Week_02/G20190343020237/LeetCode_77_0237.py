#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#
# https://leetcode-cn.com/problems/combinations/description/
#
# algorithms
# Medium (71.38%)
# Likes:    188
# Dislikes: 0
# Total Accepted:    28K
# Total Submissions: 39K
# Testcase Example:  '4\n2'
#
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
#
#

# @lc code=start


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def helper(s: int, e: int, k: int):
            """
            从[s, e]中取k个元素
            """

            if e - s + 1 < k:
                return []

            if k == 0:
                return [[]]

            ans = []
            for i in range(s, e + 1):
                for l in helper(i + 1, e, k - 1):
                    ans.append([i] + l)

            return ans
        return helper(s=1, e=n, k=k)


# @lc code=end
