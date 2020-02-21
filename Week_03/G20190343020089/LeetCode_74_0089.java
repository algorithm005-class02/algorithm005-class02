/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) return false;
        int lo = 0, hi = 0, mid = 0, x = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                x = i;
                break;        
            }
        }
        if (x == -1) return false;
        hi = matrix[x].length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            if (matrix[x][mid] <= target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return matrix[x][lo] == target;
    }
}
// @lc code=end

