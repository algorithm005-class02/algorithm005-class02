/**
 * 最佳买卖股票时机含冷冻期
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Leetcode_309_bestTimeToBuyAndSellStockWithCooldown {

    /**
     * 方法1：DP
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], - prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 方法2：DP 变量简化
     */
    public int maxProfit2(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        int dpPrev0 = 0;
        int dpi0 = 0;
        int dpi1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int tmp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + price);
            dpi1 = Math.max(dpi1, dpPrev0 - price);
            dpPrev0 = tmp;
        }
        return dpi0;
    }

}
