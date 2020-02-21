public class Solution {
    
    //解法一，额外数组空间复杂度较高
    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int [][]dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for(int i = 1; i<row; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j = 1; j<column; j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i = 1; i<row; i++){
            for(int j = 1; j<column; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][column-1];
    }
    
    //解法二，无额外数组空间复杂度为O(1).
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for(int i = 1; i<row; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1; i<column; i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i = 1; i<row; i++){
            for(int j = 1; j<column; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][column-1];
    }
}