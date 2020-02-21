/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1)return 0;
        obstacleGrid[0][0]=1;//到达第一个格子的方式数目：1
        for(int i=1;i<m;i++){//给第一列赋值，当前网格的值依赖于上一行这一列格子中的值是否可行
            obstacleGrid[i][0]=(obstacleGrid[i][0]==0&&obstacleGrid[i-1][0]==1)?1:0;
        }
        for(int j=1;j<n;j++){//给第一行赋值，当前网格的值依赖于上一列这一行格子中的值是否可行
            obstacleGrid[0][j]=(obstacleGrid[0][j]==0&&obstacleGrid[0][j-1]==1)?1:0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }else{
                    obstacleGrid[i][j]=0;
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
// @lc code=end

