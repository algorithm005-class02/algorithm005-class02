/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class Leetcode_714_bestTimeToBuyAndSellStockWithTransactionFee {
    /**
     * 方法1： DP
     */
    public int maxProfit(int[] prices, int fee) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 方法2：DP 状态变量简化
     */
    public int maxProfit2(int[] prices, int fee) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        int dpi0 = 0;
        int dpi1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int tmp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + price);
            dpi1 = Math.max(dpi1, tmp - price - fee); // fee放下面是为了防止溢出
        }
        return dpi0;
    }
}
