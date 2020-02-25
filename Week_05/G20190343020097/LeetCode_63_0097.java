package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2020/2/9 15:23
 *  * @description
 *  
 */
public class LeetCode_63_0097 {


    /**
     * 递归
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid[0].length, n = obstacleGrid.length;
        Integer[][] grid = new Integer[n][m];
        int p = getPath(obstacleGrid, grid, m, n, 0, 0);
        return p;
    }

    public int getPath(int[][] obstacleGrid, Integer[][] grid, int m, int n, int i, int j) {
        if (i == n - 1 && j == m - 1) {
            if (obstacleGrid[i][j] == 1) {
                grid[i][j] = 0;
            } else {
                grid[i][j] = 1;
            }
            return grid[i][j];
        }
        if (obstacleGrid[i][j] == 1) {
            grid[i][j] = 0;
            return grid[i][j];
        }
        if (grid[i][j] == null) {
            if (i == n - 1) {
                grid[i][j] = getPath(obstacleGrid, grid, m, n, i, j + 1) == 1 ? 1 : 0;
            } else if (j == m - 1) {
                grid[i][j] = getPath(obstacleGrid, grid, m, n, i + 1, j) == 1 ? 1 : 0;
            } else {
                grid[i][j] = getPath(obstacleGrid, grid, m, n, i + 1, j) + getPath(obstacleGrid, grid, m, n, i, j + 1);
            }
        }
        return grid[i][j];
    }

    /**
     * 递推
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        if (obstacleGrid[r - 1][c - 1] == 1) return 0;
        int[][] grid = new int[r][c];
        grid[0][0] = 1;
        //递推第一列(实际最后一列)
        for (int i = 1; i < r; i++) {
            grid[i][0] = (obstacleGrid[r - i - 1][c - 1] == 1 || grid[i - 1][0] == 0) ? 0 : 1;
        }
        //递推第一行(实际最后一行)
        for (int i = 1; i < c; i++) {
            grid[0][i] = (obstacleGrid[r - 1][c - i - 1] == 1 || grid[0][i - 1] == 0) ? 0 : 1;
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                grid[i][j] = obstacleGrid[r - i - 1][c - j - 1] == 1 ? 0 : (grid[i - 1][j] + grid[i][j - 1]);
            }
        }
        return grid[r - 1][c - 1];
    }
}
