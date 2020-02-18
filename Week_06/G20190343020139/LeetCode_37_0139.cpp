/*
 * @lc app=leetcode.cn id=37 lang=cpp
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (58.85%)
 * Likes:    313
 * Dislikes: 0
 * Total Accepted:    18.6K
 * Total Submissions: 31.3K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if(board.size()==0) return ;
        solve(board);
    }
private:
    bool solve(vector<vector<char>>& board){
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[0].size(); j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isvalid(board, i, j, k)){
                            board[i][j] = k;
                            if(solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    bool isvalid(vector<vector<char>>& board, int row, int col, char k){
        int blk = (row/3)*3 + col/3;
        for(int i = 0; i < 9; i++){
            if(board[i][col] != '.' && board[i][col] == k) return false;
            if(board[row][i] != '.' && board[row][i] == k) return false;
            if(board[(row/3)*3 + i/3][(col/3)*3 + i%3] != '.' && board[(row/3)*3 + i/3][(col/3)*3 + i%3] == k) return false;
        }
        return true;
    }

};
// @lc code=end

