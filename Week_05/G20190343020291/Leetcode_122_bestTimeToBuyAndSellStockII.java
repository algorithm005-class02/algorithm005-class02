/**
 * 买卖股票的最佳时机
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Leetcode_122_bestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
