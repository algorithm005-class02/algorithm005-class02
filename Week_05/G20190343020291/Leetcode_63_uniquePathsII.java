/**
 * 不同路径II（有障碍物）
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Leetcode_63_uniquePathsII {
    /**
     * 方法1： "傻"递归
     * （会超时）
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return helper(0, 0, obstacleGrid);
    }

    private int helper(int i, int j, int[][] obstacleGrid) {
        if (i > obstacleGrid.length - 1 || j > obstacleGrid[0].length - 1
                || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }

        return helper(i + 1, j, obstacleGrid) + helper(i, j + 1, obstacleGrid);
    }


    /**
     * 方法2：记忆化搜索
     * (会超时)
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return helper(0, 0, obstacleGrid, new int[m][n], m, n);
    }

    private int helper(int i, int j, int[][] obstacleGrid, int[][] memo, int m, int n) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (memo[i][j] == 0) {
            memo[i][j] = helper(i + 1, j, obstacleGrid, memo, m, n)
                    + helper(i, j + 1, obstacleGrid, memo, m, n);
        }

        return memo[i][j];
    }



    /**
     * 方法3： Bottom Up
     *
     */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) ? 0 : 1;
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) ? 0 : 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 方法3： Bottom Up
     * 使用一维数组记录状态
     */
    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp [j] += dp [j - 1];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        Leetcode_63_uniquePathsII solution = new Leetcode_63_uniquePathsII();
        long timeBegin = System.currentTimeMillis();
        System.out.println(solution.uniquePathsWithObstacles2(obstacleGrid));
        System.out.println(System.currentTimeMillis() - timeBegin);
    }
}

