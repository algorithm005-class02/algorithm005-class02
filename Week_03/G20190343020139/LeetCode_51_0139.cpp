/*
 * @lc app=leetcode.cn id=51 lang=cpp
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (66.87%)
 * Likes:    298
 * Dislikes: 0
 * Total Accepted:    22K
 * Total Submissions: 32.8K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * Your runtime beats 17.47 % of cpp submissions
 * Your memory usage beats 20.71 % of cpp submissions (18.8 MB)
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> result;
    int isOk(int row, int n, vector<int> position){
        for(int i = 0; i < row; i++){
            if(position[row] == position[i] || row-position[row]==i-position[i] || row+position[row]==i+position[i])
                return 0;
        }
        return 1;
    }
    void backtrack(int row, int n, vector<int> position){
        if(row == n) {
            vector<string> temp;
            for(int i = 0; i < n; i ++){
                string now = "";
                for(int j = 0; j < n; j++){
                    if(j==position[i]) now+="Q";
                    else now+=".";
                }
                temp.push_back(now);
            }
            result.push_back(temp);
        }
        else{
            for(int i = 0; i < n;i++){
                position[row] = i;
                if(isOk(row, n, position)){
                    backtrack(row+1,n,position);
                }
            }
        }
        
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<string> v;
        vector<int> queen(n,-1);
        if(n <= 0) {
            v.push_back("");
            result.push_back(v);
        }
        if(n == 1) {
            v.push_back("Q");
            result.push_back(v);
        }
        if(n > 2) {
            backtrack(0,n,queen);
        }
        return result;
    }
};
// @lc code=end

