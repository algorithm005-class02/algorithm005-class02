import java.util.TreeSet;

/**
 * 矩形区域不超过K的最大数值和
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class Leetcode_363_maxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] colSum = new int[m];
            for (int j = i; j < n; j++) {
                for (int s = 0; s < m; s++) {
                    colSum[s] += matrix[s][j];
                }
                res = Math.max(res, findMax(colSum, k));
            }
        }
        return res;
    }

    private int findMax(int[] arr, int k) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int data : arr) {
            sum += data;
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                res = Math.max(res, sum - ceiling);
            }
            set.add(sum);
        }
        return res;
    }
}
