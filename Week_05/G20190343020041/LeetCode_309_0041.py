# 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
#
# 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
#
#
# 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
# 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
#
#
# 示例:
#
# 输入: [1,2,3,0,2]
# 输出: 3
# 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1],dp[i-2][0] - prices[i])

        dp[0] = 负天. 没有开始交易
        d[1] = 第一天

        :param prices:
        :return:
        """

        if len(prices) < 2:
            return 0

        dp = [[0, -prices[0]] for _ in range(len(prices))]
        dp[1][0] = max(dp[0][0], dp[0][1] + prices[1])
        dp[1][1] = max(dp[0][1], -prices[1])

        for i in range(2, len(prices)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
        return dp[-1][0]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxProfit([1, 2, 4]))
