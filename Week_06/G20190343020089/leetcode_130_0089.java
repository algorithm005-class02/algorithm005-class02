

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    private static final int[] X = new int[]{1, 0, -1, 0};
    private static final int[] Y = new int[]{0, 1, 0, -1};

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length - 1, n = board[0].length - 1, i = 0, j = 0; 
        while (true) {
            if (board[i][j] == 'O') {
                dfs(i, j, board);
            }
            if (i == 0 && j < n) j++;
            else if (i < m && j == n) i++;
            else if (i == m && j > 0) j--;
            else if (j == 0 && i > 0) i--;
            if (i == 0 && j == 0) break;
        }
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = '-';
        for (int k = 0; k < 4; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            dfs(x, y, board); 
        } 
    }

    // private void print(char[][] board) {
    //     for (int i = 0; i < board.length; i++) {
    //         System.out.println(Arrays.toString(board[i]));
    //     }
    // }


}
// @lc code=end

