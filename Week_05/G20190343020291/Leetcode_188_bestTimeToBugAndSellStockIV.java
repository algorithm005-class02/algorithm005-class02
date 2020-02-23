/**
 * 买卖股票的最佳时机 IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Leetcode_188_bestTimeToBugAndSellStockIV {
    /**
     * 方法1：DP三维数组
     */
    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        if (k > n / 2) {
            return greedyMaxProfit(prices);
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    private int greedyMaxProfit(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                res += nums[i] - nums[i - 1];
            }
        }
        return res;
    }

    /**
     * 方法2：DP 二维数组表示
     */
    public int maxProfit2(int k, int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        if (k > n / 2) {
            return greedyMaxProfit(prices);
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int tmpMax = - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax,  dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }


}
