class Solution {
    public int uniquePaths(int m, int n) {
        //DP
//        int[][] dp = new int[m][n];
//        for (int i = 0;i < m;i++) {
//            dp[i][0] = 1;
//        }
//        for (int j = 0;j < n;j++) {
//            dp[0][j] = 1;
//        }
//        for (int i = 1;i < m;i++) {
//            for (int j = 1;j < n;j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
        //升级版空间复杂度为O(n)
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}