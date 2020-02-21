/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (63.33%)
 * Likes:    356
 * Dislikes: 0
 * Total Accepted:    50.6K
 * Total Submissions: 79.2K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

//子问题 problem(i,j) = min(sub(i-1,j),sub(i,j-1)) + a[i,j]
//状态数组 dp[i] 最小值
//DP方程 dp[i,j] = min(f[i-1,j], f[i,j-1]) + a[i,j]
// except:
// if i == 0 && j == 0 dp[i][j] = a[i][j]
// if i == 0 dp[i][j] = dp[i][j-1] + a[i][j]
// if j == 0 dp[i][j] = dp[i-1][j] + a[i][j]


// @lc code=start
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {

        int m = grid.size();
        int n = grid[0].size();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(i==0&&j==0) continue;
                if(i == 0)
                    grid[i][j] += grid[i][j-1];
                else if(j == 0)
                    grid[i][j] += grid[i-1][j];
                else grid[i][j] += min(grid[i-1][j], grid[i][j-1]);

            }
        }
        return grid[m-1][n-1];

    }
private:
    int min(int a, int b){
        return a < b ? a : b;
    }
};
// @lc code=end

