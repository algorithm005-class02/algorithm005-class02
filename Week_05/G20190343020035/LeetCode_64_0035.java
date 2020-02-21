public class LeetCode_64_0035{


    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[grid.length][grid[0].length] = grid[grid.length][grid[0].length];
        for (int i = grid.length - 1 ; i>=0;i--){
            for (int j = grid[0].length - 1; j >= 0;j--){
                if( j == grid[0].length-1 && i != grid.length-1){
                    dp[i][j] = grid[i][j];
                }
                if( i == grid.length-1 && j != grid[0].length-1){
                    dp[i][j] = grid[i][j];
                }
                if(i!= grid.length-1 && j != grid[0].length-1){
                    dp[i][j] = grid[i][j] + Math.min(grid[i+1][j],grid[i][j+1]);
                }
            }
        }
        return dp[0][0];

    }
}
