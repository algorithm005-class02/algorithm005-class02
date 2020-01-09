class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.empty() || grid[0].empty()) return 0;
        for (int i = 0; i < grid.size(); i++)
        {
            if (i > 0)
            {
                grid[i][0] += grid[i - 1][0];
            }
            for (int j = 1; j < grid[0].size(); j++)
            {
                if (i == 0)
                grid[i][j] += grid[i][j - 1];
                else
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid.back().back();
    }
};