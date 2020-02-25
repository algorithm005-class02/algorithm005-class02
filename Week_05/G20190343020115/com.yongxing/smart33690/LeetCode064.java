package smart33690;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小路径和
 */
public class LeetCode064 {
    public static void main(String[] args) {
        LeetCode064 in = new LeetCode064();
        int[][] a = {
                {1,3,1},
                {1,5,1},
                {4,2,1}};
        int res = in.minPathSum(a);

        System.out.println(res);
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
}
