class Solution {
    private static final int MAX = 9;

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != MAX || board[0].length != MAX) {
            return;
        }

        this.backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (backtrack(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }

                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < MAX; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == c) {
                return false;
            }
        }
        return true;
    }
}