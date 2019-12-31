class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int nr = matrix.length;
        for (int i = 0; i < nr; i ++) {
            int[] data = matrix[i];
            int start = 0;
            int end = data.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (data[mid] == target) {
                    return true;
                }
                if (data[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}