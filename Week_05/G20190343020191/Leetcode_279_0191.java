class Solution {
    public int numSquares(int n) {
        // 默认初始化值都为0
        int[] dp = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i; 
            for (int j = 1; i - j * j >= 0; j++) { 
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); 
            }
        }
        return dp[n];
    }
}
