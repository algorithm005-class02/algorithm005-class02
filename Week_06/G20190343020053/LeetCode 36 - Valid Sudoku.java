class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[9][10];
        boolean[][] row = new boolean[9][10];
        boolean[][] bd = new boolean[9][10];
        
        for (int i = 0;i < 9;i++) {
            for (int j = 0;j < 9;j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int bdN = checkBd(i, j);
                    if (!row[i][num] && !col[j][num] && !bd[bdN][num]) {
                        row[i][num] = true;
                        col[j][num] = true;
                        bd[bdN][num] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private int checkBd(int row, int col) {
        int tr = row / 3;
        int tc = col / 3;
        return tr * 3 + tc;
    }
}