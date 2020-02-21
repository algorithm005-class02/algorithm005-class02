class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowCnt = new int[9];
        int[] colCnt = new int[9];
        int[] boxCnt = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                int num = board[i][j] - 48;
                // 处理行
                if ((rowCnt[i] >> num) % 2 == 1) {
                    return false;
                } else {
                    rowCnt[i] += 1 << num;
                }
                // 处理列
                if ((colCnt[j] >> num) % 2 == 1) {
                    return false;
                } else {
                    colCnt[j] += 1 << num;
                }
                // 处理框
                int boxNum = i / 3 * 3 + j / 3;
                if ((boxCnt[boxNum] >> num) % 2 == 1) {
                    return false;
                } else {
                    boxCnt[boxNum] += 1 << num;
                }
            }
        }
        return true;
    }
}