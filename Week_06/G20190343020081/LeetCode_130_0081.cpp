class Solution {
public:
    void solve(vector<vector<char>>& board) {
        if ( board.size() ==0 )
            return;
        int m = board.size();
        int n = board[0].size();
        for ( int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++) {
                bool isEdge = i == 0 || j == 0 || i == m -1 || j == n -1;
                if ( isEdge && board[i][j] == 'O') {
                    dfs(board, i , j);
                }
            }
        }

        for ( int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else
                    board[i][j] = 'X';
            }
        }

        return;
    }

private:
    void dfs(vector<vector<char>>& board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.size()  || j >= board[0].size() || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        board[i][j] = '#';
        dfs(board, i - 1, j); 
        dfs(board, i + 1, j); 
        dfs(board, i, j - 1); 
        dfs(board, i, j + 1); 
        return;
    }
};
