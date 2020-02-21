class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        int m = 0;
        int n = 0;
        m = matrix.length;
        n = matrix[0].length;
        Set<Integer> cols = new HashSet<Integer>();
        Set<Integer> rows = new HashSet<Integer>();
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(cols.contains(j) || rows.contains(i)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}