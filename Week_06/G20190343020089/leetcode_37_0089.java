
/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */




 // @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        int[][] row = new int[10][10];
        int[][] col = new int[10][10];
        int[][] squ = new int[10][10];
        init(row, col, squ, board);
        dfs(row, col, squ, 0, 0, board);
    }

    private boolean init(int[][] row, int[][] col, int[][] squ, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    if (row[i][k] == 1) return false; else row[i][k] = 1; 
                    if (col[j][k] == 1) return false; else col[j][k] = 1;
                    if (squ[(i / 3) * 3 + j / 3][k] == 1) return false; else squ[(i / 3) * 3 + j / 3][k] = 1;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] row, int[][] col, int[][] squ, int i, int j, char[][] board) {
        while (i < 9 && board[i][j] != '.') {
            if (j == 8) {
                i++;
                j = 0;
            } else {
                j++;
            }
        }
        if (i == 9) return true;
        for (int t = 1; t <= 9; t++) {
            if (isOkNum(row, col, squ, i, j, t)) {
                setNum(row, col, squ, board, i, j, t);
                if (j == 8) {
                    if (dfs(row, col, squ, i + 1, 0, board)) return true;
                } else {
                    if (j == 8) System.out.println(j); 
                    if (dfs(row, col, squ, i, j + 1, board)) return true;
                }
                removeNum(row, col, squ, board, i, j, t);
            }
        }
        return false;
    }

    private boolean isOkNum(int[][] row, int[][] col, int[][] squ, int i, int j, int k) {
        return !(row[i][k] == 1 || col[j][k] == 1 || squ[(i / 3) * 3 + j / 3][k] == 1);
    }

    private void setNum(int[][] row, int[][] col, int[][] squ, char[][] board, int i, int j, int k) {
        board[i][j] = (char) (k + '0');
        row[i][k] = 1;
        col[j][k] = 1;
        squ[(i / 3) * 3 + j / 3][k] = 1;
    }

    private void removeNum(int[][] row, int[][] col, int[][] squ, char[][] board, int i, int j, int k) {
        board[i][j] = '.';
        row[i][k] = 0;
        col[j][k] = 0;
        squ[(i / 3) * 3 + j / 3][k] = 0;
    }
}
// @lc code=end

