/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 */

// @lc code=start
#include<vector>

using namespace std;

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.size() == 0) return 0;
        vector<int> dp(grid[0].size(),0);
        for(int i = grid.size() - 1; i >= 0; --i){
            for(int j = grid[0].size() - 1; j >= 0 ; --j){
                if(i == grid.size() - 1 && j != grid[0].size() - 1){
                    dp[j] = grid[i][j] + dp[j+1];
                }else if(j == grid[0].size() - 1 && i != grid.size() - 1){
                    dp[j] = grid[i][j] + dp[j];
                }else if(j != grid[0].size() - 1 && i != grid.size() - 1){
                    dp[j] = std::min(dp[j],dp[j+1]) + grid[i][j];
                }else{
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    int minPathSum1(vector<vector<int>>& grid) {
        if(grid.size() == 0) return 0;
        vector<vector<int>> dp(grid.size(), vector<int>(grid[0].size(),0));
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.size(); ++i){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < grid[0].size(); ++j){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for(int i = 1; i < grid.size(); ++i){
            for(int j = 1; j < grid[0].size(); ++j){
                dp[i][j] = std::min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.size()-1][grid[0].size()-1];
    }
};
// @lc code=end


