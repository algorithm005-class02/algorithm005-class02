package G20190343020097;

/**
 *  * @author jiangli
 *  * @date 2020/2/9 15:23
 *  * @description
 *  
 */
public class LeetCode_62_0097 {


    /**
     * 递归
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        Integer[][] grid = new Integer[m][n];
        int p = getPath(grid, m, n, 0, 0);
        return p;
    }

    public int getPath(Integer[][] grid, int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1) {
            grid[i][j] = 1;
        }
        if (grid[i][j] == null) {
            grid[i][j] = getPath(grid, m, n, i + 1, j) + getPath(grid, m, n, i, j + 1);
        }
        return grid[i][j];
    }

    /**
     * 递推
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0;i<m;i++) grid[0][i] = 1;
        for(int i = 0;i<n;i++) grid[i][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                grid[i][j] = grid[i-1][j]+ grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}
