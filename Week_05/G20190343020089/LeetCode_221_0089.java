import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') maxArea = Math.max(maxArea, 49); 
                if ((i > 0 && matrix[i - 1][j] >= '1') && (j > 0 && matrix[i][j - 1] >= '1') 
                    && (i > 0 && j > 0 && matrix[i - 1][j - 1] >= '1') && matrix[i][j] == '1') {
                    matrix[i][j] =  (char) (Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1);
                    maxArea = Math.max(maxArea, matrix[i][j]);
                }
            }
        }
        if (maxArea != 0) maxArea -= 48;
        return maxArea  * maxArea;
    }
}
// @lc code=end

