import org.junit.Test;

public class LeetCode_221_0035{
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxRs = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxRs = Math.max(maxRs, dp[i][j]);
                }
            }
        }
        return maxRs * maxRs;
    }


    @Test
    public void test(){
      //  [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
           char[][] aa = new char[][]{
                           { '1','0','1','0','0'},
                           { '1','0','1','1','1'},
                           { '1','1','1','1','1'},
                           { '1','0','0','1','0'}
                         };

        /*char[][] aa = new char[][]{

                                 };*/
           System.out.println(maximalSquare(aa));
    }
}
