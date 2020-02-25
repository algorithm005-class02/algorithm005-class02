/**
 * 编辑距离
 * https://leetcode.com/problems/edit-distance/
 */
public class Leetcode_72_editDistance {

    /**
     * 方法1： DP
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i][j]));
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 方法2：DP 仅使用一维数组存储状态
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            dp[i] = i;
        }

        for (int j = 1; j <= n; j++) {
            int prev = dp[0];
            dp[0] = j;
            for (int i = 1; i <= m; i++) {
                int tmp = dp[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i] = prev;
                } else {
                    dp[i] = 1 + Math.min(tmp, Math.min(dp[i - 1], prev));
                }
                prev = tmp;
            }
        }
        return dp[m];
    }
}
