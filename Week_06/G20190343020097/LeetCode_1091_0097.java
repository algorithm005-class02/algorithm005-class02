package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2020/2/27 20:02
 *  * @description
 *  
 */
public class LeetCode_1091_0097 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        return dp( grid);
    }

    public int dp(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        dp[m-1][n-1] = 0;
        //最后一列
        for(int i = 1;i<m;i++){
            dp[m - i - 1][n - 1] = grid[m - i - 1][n - 1] == 1 ? 0 : grid[m - i][n - 1] + 1;
        }
        //最后一行
        for(int i = 1;i<n;i++){
            dp[m - 1][n - i - 1] = grid[m - 1][n - i - 1] == 1 ? 0 : grid[m - 1][n - i] + 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if(grid[i][j] == 0 ){
                    grid[i][j] = getMin(grid[i+1][j+1],grid[i+1][j],grid[i][j+1]);
                }
            }
        }
        System.out.println(grid[0][0]);
        return grid[0][0];
    }

    public int getMin(Integer n1,Integer n2,Integer n3){
        return  Math.min(n1,Math.min(n2,n3));
    }
}
