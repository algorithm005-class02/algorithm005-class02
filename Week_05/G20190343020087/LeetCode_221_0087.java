/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        
        int S[][] = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i == 0 || j == 0) S[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '0') S[i][j] = 0;
                else {
                    S[i][j] = Math.min(S[i][j-1], Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                }
                
                if (max < S[i][j]) max = S[i][j];
            }
        }
        return max*max;
    }
}
// @lc code=end

