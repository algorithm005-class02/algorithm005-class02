class Solution {
    //dp: dp(x, y) = max(dp(x - 1, y), dp(x, y -1)) + a[i]; 
public:
    int minPathSum(vector<vector<int>>& grid) {
        int dp[grid.size()][grid.back().size()];
        memset(dp, 0, sizeof(dp));
        dp[0][0] = grid[0][0];
        for(int i = 1; i <  grid.back().size(); i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int j = 1; j < grid.size(); j++) {
             dp[j][0] = dp[j - 1][0] + grid[j][0];     
        }   
        for(int i = 1; i < grid.size(); i++) {
            for(int j = 1; j < grid.back().size(); j++) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j -1]) + grid[i][j];
            }   
        }

        return dp[grid.size() -1][grid.back().size() -1];
    }
};