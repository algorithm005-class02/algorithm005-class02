class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        money = 0
        for day in range(len(prices) - 1):
            price, nextPrice = prices[day], prices[day + 1]
            if nextPrice > price:
                money += nextPrice - price
        return money