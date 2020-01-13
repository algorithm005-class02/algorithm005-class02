/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (31.97%)
 * Likes:    204
 * Dislikes: 0
 * Total Accepted:    35.8K
 * Total Submissions: 111.2K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 */

// @lc code=start
//DP1，自底向上。
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //拿取二维数组的长度
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        //如果start[0][0]位置为1，那么该路径是为0
        if(obstacleGrid[0][0] == 1) return 0;
        //初始化start位置路径数
        obstacleGrid[0][0] = 1;
        //初始化第一行的每一格路径值
        for(int i = 1;i < row; ++ i){
            obstacleGrid[i][0] = (obstacleGrid[i-1][0] == 1 && obstacleGrid[i][0] == 0 )?1:0;
        }
        //初始化第一列的每一格路径值
        for(int i = 1;i < col; ++ i){
            obstacleGrid[0][i] = (obstacleGrid[0][i-1] == 1 && obstacleGrid[0][i] == 0)?1:0;
        }
        //开始dp
        for(int i = 1;i < row;++ i){
            for(int j = 1;j < col; ++ j){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }else{
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
}
*/

//dp2 国际站java解法，更简洁的代码，仅进行一次初始化，时间复杂度最优
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
*/


//自顶向下，记忆化搜索
class Solution {
    int res;
    public int row;
    public int col;
    public int[][] memo;
    int count = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //记忆化搜索
        row = obstacleGrid.length;
        col = obstacleGrid[0].length;
        //memo = new int[row + 1][col + 1];
        memo = new int[row + 1][col + 1];
        //如果start[0][0]位置为1，那么该路径是为0
        if (obstacleGrid[0][0] == 1) return 0;
        //memo = new int[row-1][col-1];
        dfs(0, 0, obstacleGrid,memo);
        return res;
    }

    public int dfs(int x, int y, int[][] obstacleGrid,int[][]memo) {

        // if(count == 0) return 0;
        if(memo[0][0]!=0) return 0;

        //如果memo已存在，剪枝，返回上一层
        if(memo[x][y] !=0){
            return memo[x][y];
        }
        res = 0;
        //if(memo[x][y]!=0) return memo[x][y] = res;

        //如果memo已存在，剪枝，返回上一层
        if(x < row && y <col && memo[x][y] ==0 && obstacleGrid[x][y] == 1){
            return memo[x][y];
        }
        //Terminator
        if (x == row - 1 && y == col - 1 && obstacleGrid[x][y] != 1) {
            if(memo[x][y] !=0){
                return memo[x][y];
            }
            res ++;
            return memo[x][y]=res;
        }
        if (x >= row || y >= col || obstacleGrid[x][y] == 1) {
            if(memo[x][y] !=0){
                return memo[x][y];
            }
            res = 0;
            return memo[x][y]=res;
        }
        //drill down
        if (x <= row - 1)
            res += dfs(x + 1, y, obstacleGrid,memo);
        if (y <= col - 1)
            res += dfs(x, y + 1, obstacleGrid,memo);
        return memo[x][y]=res;

    }
//     public static void main(String[] args) {
//         Solution cp = new Solution();
// //        int[][] ob = {{0,0,0},{0,1,0},{0,0,0}};
//           //int[][] ob = {{0}};
//           //int[][] ob = {{0,0},{1,1},{0,0}};
//         int[][] ob = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
// //        int[][] ob = {{0,0,0,0,0},{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0}};

//         System.out.println(cp.uniquePathsWithObstacles(ob));

//         //System.out.println(cp.n);
//         //System.out.println(cp.m);
    // }
    

}


// @lc code=end

