import java.util.Arrays;

/**
 * 不同路径
 * https://leetcode.com/problems/unique-paths/
 */
public class Leetcode_62_uniquePaths {
    /**
     * 方法1："傻"递归 （Leetcode会超时 922ms）
     */
    public int uniquePaths(int m, int n) {
        return helper(m, n, 1, 1);
    }

    private int helper(int m, int n, int i, int j) {
        if (m == i && j == n) {
            return 1;
        }

        if (i > m || j > n) {
            return 0;
        }

        return helper(m, n, i+1, j) + helper(m, n, i, j+1);
    }



    /**
     * 方法2：记忆化搜索
     */
    public int uniquePaths2(int m, int n) {
        return helper(m - 1, n - 1, 0, 0, new int[m][n]);
    }

    private int helper(int m, int n, int i, int j, int[][] memo) {
        if (m == i && j == n) {
            return 1;
        }

        if (i > m || j > n) {
            return 0;
        }
        if (memo[i][j] == 0) {
            memo[i][j] = helper(m, n, i+1, j, memo) + helper(m, n, i, j+1, memo);
        }

        return memo[i][j];
    }


    /**
     * 方法3：Bottom Up
     * (使用二维数组存储状态）
     */
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++)  {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 方法3：Bottom Up
     * (优化：使用一维数组存储状态）
     */
    public int uniquePaths4(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }

        return dp[n - 1];
    }



}
