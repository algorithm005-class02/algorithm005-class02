class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int right = m * n - 1;
        int left = 0;
        while (left <= right) {
            int mind = (left + right) / 2;
            int tmp = matrix[mind / n][mind % n];
            if (target == tmp) {
                return true;
            } else if (target > tmp) {
                left = mind + 1;
            } else {
                right = mind - 1;
            }
        }
        return false;
    }
}