/**
 * 搜搜二维矩阵
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Leetcode_74_searchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
