/**
 * 不同的子序列
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class Leetcode_115_distinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
