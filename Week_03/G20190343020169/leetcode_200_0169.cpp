/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 */

// @lc code=start
#include<vector>

using namespace std;

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0){
            return 0;
        }
        vector<vector<int>> rounding = {{-1,0},{0,-1},{1,0},{0,1}};

        int count = 0;
        for(int i = 0; i < grid.size(); ++i){
            for(int j = 0; j < grid[i].size(); ++j){
                if(grid[i][j] == '1'){
                    grid[i][j] = 'M';
                    dfs(grid, rounding, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(vector<vector<char>>& grid, vector<vector<int>> &rounding, int row, int col){
        for(int k = 0; k < rounding.size(); ++k){
            if(row + rounding[k][0] >= 0 && row + rounding[k][0] < grid.size() 
                && col + rounding[k][1] >= 0 && col + rounding[k][1] < grid[0].size()){
                if(grid[row + rounding[k][0]][col + rounding[k][1]] == '1'){
                    grid[row + rounding[k][0]][col + rounding[k][1]] = 'M';
                    dfs(grid, rounding, row + rounding[k][0], col + rounding[k][1]);
                }
            }
        }  
    }
};
// @lc code=end
