public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] s = new int[m][n];
        s[0][0] = obstacleGrid[0][0]==0 ? 1:0;
        if(s[0][0] == 0) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1) s[i][j] = 0;
                else if(i==0){
                    if(j>0) s[i][j] = s[i][j-1];
                }
                else if(j==0){
                    if(i>0) s[i][j] = s[i-1][j];
                }
                else s[i][j] = s[i-1][j] + s[i][j-1];
            }
        }
        return s[m-1][n-1];
    }