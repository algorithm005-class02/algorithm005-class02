#
# @lc app=leetcode.cn id=122 lang=python3
#
# [122] 买卖股票的最佳时机 II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 贪心 mine   99%  97%
        # if not prices: return 0
        # pre, profits = prices[0], 0
        # for i in range(1, len(prices)):
        #     if prices[i] > pre:
        #         profits += prices[i] - pre
        #     pre = prices[i]
        # return profits

        # 贪心 short   99%  97%
        if not prices: return 0
        profits = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                profits += prices[i] - prices[i - 1]
        return profits
        
# @lc code=end

