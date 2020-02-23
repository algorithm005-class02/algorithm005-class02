/**
 * 最小路径和
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Leetcode_64_minimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == m - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == n - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 方法2：DP 状态化简为一维数组
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[j] = grid[i][j];
                } else if (i == m - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j == n - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    /**
     * 方法3：递归+记忆化搜索
     */
    public int minPathSum3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        return helper(grid, count, 0, 0, m, n);
    }

    private int helper(int[][] grid, int[][] count, int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        } else if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        } else if (count[i][j] > 0) {
            return count[i][j];
        } else {
            return count[i][j] = grid[i][j] + Math.min(helper(grid, count, i + 1, j, m, n),
                    helper(grid, count, i, j + 1, m, n));
        }
    }
}
