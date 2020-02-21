/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        // 判断每个单词
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrace(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrace(char[][] board, int row, int col, String word, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index))
            return false;
        if (index == word.charAt(index))
            return true;
        if (index == word.length() - 1)
            return true;
        char temp = board[row][col];
        board[row][col] = '$';
        boolean up = backtrace(board, row - 1, col, word, index + 1);
        if (up) {
            board[row][col] = temp; // 将 board 还原, 79 题中的代码没有还原，这里必须还原
            return true;
        }
        boolean down = backtrace(board, row + 1, col, word, index + 1);
        if (down) {
            board[row][col] = temp;// 将 board 还原, 79 题中的代码没有还原，这里必须还原
            return true;
        }
        boolean left = backtrace(board, row, col - 1, word, index + 1);
        if (left) {
            board[row][col] = temp;// 将 board 还原, 79 题中的代码没有还原，这里必须还原
            return true;
        }
        boolean right = backtrace(board, row, col + 1, word, index + 1);
        if (right) {
            board[row][col] = temp;// 将 board 还原, 79 题中的代码没有还原，这里必须还原
            return true;
        }
        board[row][col] = temp;
        return false;

    }
}
// @lc code=end
