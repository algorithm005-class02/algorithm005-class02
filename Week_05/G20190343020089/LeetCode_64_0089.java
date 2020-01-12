

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[] dp = new int[grid[0].length];
        int k = 0;
        for (int i = 0; i < dp.length; i++) {
            k += grid[0][i];
            dp[i] = k;
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < dp.length; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];  
            }
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end

