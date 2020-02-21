package org.crayzer.leetcode.editor.en.advanced_search;

import java.util.Arrays;

public class LeetCode_37_SudokuSolver {

    class Solution2 {
        public void solveSudoku(char[][] board) {
            dfs(board, 0);
        }

        private boolean dfs(char[][] board, int d) {
            if (d == 81) return true;
            int i = d / 9, j = d % 9;
            if (board[i][j] != '.') return dfs(board, d + 1);

            boolean[] flag = new boolean[10];
            validate(board, i, j, flag);
            for (int k = 1; k<= 9; k++) {
                if (flag[k]) {
                    board[i][j] = (char)('0' + k);
                    if (dfs(board, d + 1)) return true;
                }
            }
            board[i][j] = '.';
            return false;
        }

        private void validate(char[][] board, int row, int col, boolean[] flag) {
            Arrays.fill(flag, true);
            for (int i = 0; i < 9; i++) {
                if (board[row][i] != '.') flag[board[row][i] - '0'] = false;
                if (board[i][col] != '.') flag[board[i][col] - '0'] = false;
                int r = row / 3 * 3 + i / 3;
                int c = col / 3 * 3 + i % 3;
                if (board[r][c] != '.') flag[board[r][c] - '0'] = false;
            }
        }
    }

    class Solution1 {
        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) return;
            solve(board);
        }

        private boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c;
                                if (solve(board)) return true;
                                // else board[i][j] = '.';
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.' && board[i][col] == c) return false;
                if (board[row][i] != '.' && board[row][i] == c) return false;
                if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                        board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
            }
            return true;
        }
    }
}
