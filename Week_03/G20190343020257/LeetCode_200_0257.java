class Solution {
    
    public void mark(char[][] grid, int i, int j) {
        if (grid.length == i || i < 0) {
            return;
        }
        if (grid[0].length == j || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            mark(grid, i, j - 1);
            mark(grid, i, j + 1);
            mark(grid, i - 1, j);
            mark(grid, i + 1, j);
        }
    }
    
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    sum += 1;
                    mark(grid, i, j);
                }
            }
        }
        return sum;
    }
}