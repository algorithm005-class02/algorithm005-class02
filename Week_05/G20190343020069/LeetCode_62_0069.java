package leetcode.week05;

public class LeetCode_62_0069 {

    public static void main (String args[]) {
        System.out.println(uniquePaths (3, 2));
    }

    /**
     * unique paths
     * m 和 n 的值均不超过 100。
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths (int m , int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
