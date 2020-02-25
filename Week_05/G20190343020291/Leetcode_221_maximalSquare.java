/**
 * 最大正方形
 * https://leetcode.com/problems/maximal-square/
 */
public class Leetcode_221_maximalSquare {
    /**
     * 方法1： DP
     */
    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
    /**
     * 方法2： DP 优化
     */
    public int maximalSquare2(char[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        int res = 0;
        int prev = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j - 1], Math.min(tmp, prev));
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return res * res;
    }

}
