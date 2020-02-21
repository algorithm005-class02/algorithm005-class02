class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arrays = new int[m][n];
        arrays[m-1][n-1] = obstacleGrid[m-1][n-1] == 1 ? 0 : 1;
        for (int i=m-2; i>=0; i--) {
            arrays[i][n-1] = obstacleGrid[i][n-1] == 1 ? 0 : arrays[i+1][n-1];
        }
        for (int j=n-2; j>=0; j--) {
            arrays[m-1][j] = obstacleGrid[m-1][j] == 1 ? 0 : arrays[m-1][j+1];
        }
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                arrays[i][j] = arrays[i+1][j] + arrays[i][j+1];
                arrays[i][j] = obstacleGrid[i][j] == 1 ? 0 : arrays[i][j];
            }
        }
        return arrays[0][0];
    }
}
