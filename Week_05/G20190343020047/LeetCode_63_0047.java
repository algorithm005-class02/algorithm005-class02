class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] rows:obstacleGrid) {
            for (int j = 0;j<width;j++) {
                if (rows[j] == 1) {
                    dp[j] = 0;
                }else if(j > 0){//j是从0开始，防止数组越界
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }
}