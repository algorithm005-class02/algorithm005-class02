class Solution {
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                board[i][j] = ".";
            }
        }
        boolean[] col = new boolean[n];
        boolean[] place1 = new boolean[2 * n - 1];
        boolean[] place2 = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<>();
        process(res, board, 0, n, col, place1, place2);
        return res;
    }
    
    private void process(List<List<String>> res, String[][] board, int index, int n, boolean[] col, boolean[] place1, boolean[] place2) {
        if (index == n) {
            res.add(build(board));
            return;
        }
        for (int i = 0;i < n;i++) {
            if (col[i] || place1[index + n - i - 1] || place2[index + i]) {
                continue;
            }
            col[i] = true;
            place1[index + n - i - 1] = true;
            place2[index + i] = true;
            board[index][i] = "Q";
            process(res, board, index + 1, n, col, place1, place2);
            col[i] = false;
            place1[index + n - i - 1] = false;
            place2[index + i] = false;
            board[index][i] = ".";
        }
    }
    
    private List<String> build(String[][] board) {
        List<String> res = new ArrayList<>();
        for (String[] strs : board) {
            String ans = "";
            for (String str : strs) {
                ans = ans + str;
            }
            res.add(ans);
        }
        return res;
    }
}