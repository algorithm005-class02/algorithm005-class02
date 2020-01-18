class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length < 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int opt[][] = new int[m][n];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        opt[0][0] = 1;
        for(int i = 1;i<m;i++) {
            opt[i][0] = (obstacleGrid[i][0] == 0 && opt[i-1][0] == 1) ? 1 : 0;
        }
        for(int j = 1;j<n;j++) {
            opt[0][j] = (obstacleGrid[0][j] == 0 && opt[0][j-1] == 1) ? 1 : 0;
        }
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    opt[i][j] = 0;
                } else {
                    opt[i][j] = opt[i-1][j] + opt[i][j-1];
                }
            }
        }
        return opt[m-1][n-1];
    }
}