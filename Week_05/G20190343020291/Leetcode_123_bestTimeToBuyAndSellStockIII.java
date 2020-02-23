/**
 * 买卖股票的最佳时机 III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Leetcode_123_bestTimeToBuyAndSellStockIII {
    /**
     * 方法1：DP方程 罗列三种状态（天数，允许的最多交易次数，是否持有股票）
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][1][1] = - prices[0];
        dp[0][2][1] = - prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j- 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    /**
     * 方法2：DP方程状态简化
     */
    public int maxProfit2(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int dpi10 = 0, dpi11 = Integer.MIN_VALUE;
        int dpi20 = 0, dpi21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dpi10 = Math.max(dpi10, dpi11 + price);
            dpi11 = Math.max(dpi11,  - price);
            dpi20 = Math.max(dpi20, dpi21 + price);
            dpi21 = Math.max(dpi21, dpi10 - price);
        }
        return dpi20;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        Leetcode_123_bestTimeToBuyAndSellStockIII solution = new Leetcode_123_bestTimeToBuyAndSellStockIII();
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit2(prices));
    }
}
