class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        p = 0
        for i in range(1, len(prices)):
            t = prices[i] - prices[i - 1]
            if t > 0:
                p += t
        return p