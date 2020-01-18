# 给定一个可包含重复数字的序列，返回所有不重复的全排列。
#
# 示例:
#
# 输入: [1,1,2]
# 输出:
# [
#  [1,1,2],
#  [1,2,1],
#  [2,1,1]
# ]
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(nums, used, path, res):
            if len(path) == len(nums):
                res.append(path[:])
                return
            for i in range(len(nums)):
                if used[i]: continue
                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]: continue
                used[i] = True
                path.append(nums[i])
                dfs(nums, used, path, res)
                used[i] = False
                path.pop()

        dfs(sorted(nums), [False] * len(nums), [], res)
        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().permuteUnique([2, 1, 1])
