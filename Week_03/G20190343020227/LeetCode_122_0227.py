class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        Profit = 0
        for i in range(1,len(prices)):
            temp = prices[i] - prices[i-1]
            if temp > 0:
                Profit = Profit + temp
        return Profit