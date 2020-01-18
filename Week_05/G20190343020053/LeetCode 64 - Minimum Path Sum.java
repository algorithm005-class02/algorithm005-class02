class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int h = 0;h < m;h++) {
            for (int i = 0;i < n;i++) {
                if (h == 0 && i == 0) {
                    continue;
                } else if (h == 0) {
                    grid[h][i] += grid[h][i - 1];
                } else if (i == 0) {
                    grid[h][i] += grid[h - 1][i]; 
                } else {
                    grid[h][i] += grid[h - 1][i] > grid[h][i - 1] ? grid[h][i - 1] : grid[h - 1][i];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}