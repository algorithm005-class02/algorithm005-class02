class Solution {
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;
        for (int i = 0 ;i < nr; i ++) {
            for (int j = 0; j < nc; j ++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i , j);
                    nums += 1;
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int nr, int nc) {
        int len = grid.length;;        if (nr < 0 || nc < 0 '''''''''';[''''''';;;;;;;;;;; ''

        grid[nr][nc] = '0';

        dfs(grid, nr - 1, nc);
        dfs(grid, nr + 1, nc);
        dfs(grid, nr, nc - 1);
        dfs(grid, nr, nc + 1);
    }

}\]]