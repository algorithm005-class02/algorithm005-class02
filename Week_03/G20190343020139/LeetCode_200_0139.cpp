/**
 * 执行用时 :16 ms, 在所有 cpp 提交中击败了59.72%的用户
 * 内存消耗 :10.7 MB, 在所有 cpp 提交中击败了91.02%的用户
 * 
**/

class Solution {
public:
    vector<vector<char>> g;
    int numIslands(vector<vector<char>>& grid) {
        int island = 0;
        g = grid;
        for(int i = 0; i < g.size(); i++){
            for(int j = 0; j < g[i].size(); j++){
                island += sink(i,j);
            }
        }
        return island;
    }
    int sink(int i, int j){
        //terminator
        if(i < 0 || j < 0 || i == g.size() || j == g[i].size() || g[i][j] == '0') return 0;
        g[i][j] = '0';
        sink(i+1,j);
        sink(i-1,j);
        sink(i,j+1);
        sink(i,j-1);
        return 1;

    }
};