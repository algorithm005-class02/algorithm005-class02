package LeetCode.week06.homework;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] vset = new int[9];
        int[] hset = new int[9];
        int[] bckt = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((hset[i] & idx) > 0 || (vset[j] & idx) > 0 || (bckt[(i / 3) * 3 + j / 3] & idx) > 0)
                        return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
}
// @lc code=end
