# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
#
# 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
#
# 注意你不能在买入股票前卖出股票。
#
# 示例 1:
#
# 输入: [7,1,5,3,6,4]
# 输出: 5
# 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
#     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
#
#
# 示例 2:
#
# 输入: [7,6,4,3,1]
# 输出: 0
# 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
#
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def maxProfitDiff(self, prices: List[int]) -> int:
        if len(prices) <= 1: return 0
        diff = [0] * (len(prices) - 1)
        for i in range(len(diff)):
            diff[i] = prices[i + 1] - prices[i]
        dp = [0] * len(diff)
        dp[0] = max(0, diff[0])
        profit = dp[0]
        for i in range(1, len(diff)):
            dp[i] = max(dp[i - 1] + diff[i], 0)
            profit = max(profit, dp[i])
        return profit

    def maxProfit(self, prices: List[int]) -> int:
        """
        状态定义:
        dp[i][j] = 第i天是否持有 j={0,1}

        base case:
        dp[0][0] = 0
        dp[0][1] = -price
        dp方程:

        :param prices:
        :return:
        """
        if len(prices) < 2:
            return 0

        dp = [[0] * 2 for _ in range(len(prices))]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1, len(prices)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        return dp[-1][0]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxProfit([1, 2, 3, 4, 5]))
