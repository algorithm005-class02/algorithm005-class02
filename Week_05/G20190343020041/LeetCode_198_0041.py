# 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
#
# 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
#
# 示例 1:
#
# 输入: [1,2,3,1]
# 输出: 4
# 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
#      偷窃到的最高金额 = 1 + 3 = 4 。
#
# 示例 2:
#
# 输入: [2,7,9,3,1]
# 输出: 12
# 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
#      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
#
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def robDP(self, nums: List[int]) -> int:
        """

        :param nums:
        :return:
        """
        if len(nums) == 0: return 0

        MAX = len(nums) + 1
        dp = [0] * MAX
        dp[0] = 0
        dp[1] = nums[0]
        for i in range(2, MAX):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1])
        return dp[-1]

    def robDP2D(self, nums: List[int]) -> int:
        """

        :param nums:
        :return:
        """
        if len(nums) == 0: return 0
        MAX = len(nums)
        dp = [[0, 0] for _ in range(MAX)]
        dp[0][1] = nums[0]
        for i in range(MAX):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = dp[i - 1][0] + nums[i]
        return max(dp[-1][0], dp[-1][1])


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().rob([1, 2, 3, 1]))
