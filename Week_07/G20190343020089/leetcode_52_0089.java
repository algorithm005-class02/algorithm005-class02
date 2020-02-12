/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {

    private int res;

    public int totalNQueens(int n) {
        if (n < 0) return 0;
        dfs(n, 0, 0, 0, 0);
        return res;
    }

    private void dfs(int n, int row, int col, int pie, int na) {
        if (row >= n) {
            res++;
            return;
        } 
        int bits = (~(col | na | pie)) & ((1 << n) - 1);
        while (bits > 0) {
            int p = bits & -bits; //取最后一个1
            dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            bits &= bits - 1; // 打掉最后一个 1;
        }   
    }
}
// @lc code=end

