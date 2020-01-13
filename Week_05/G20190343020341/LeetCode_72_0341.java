public class LeetCode_72_0341 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for(int c = 1; c <= n2; c++) {
            dp[0][c] = dp[0][c - 1] + 1;
        }

        for(int r = 1; r <= n1; r++) {
            dp[r][0] = dp[r - 1][0] + 1;
        }

        for(int r = 1; r <= n1; r++) {
            for(int c = 1; c <= n2; c++) {
                if(word1.charAt(r -1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c - 1], dp[r][c -1]), dp[r - 1][c]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
