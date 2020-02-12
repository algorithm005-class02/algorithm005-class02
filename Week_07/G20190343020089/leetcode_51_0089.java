import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {

    private int[] col, dales, hills, queens;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        col = new int[n];
        dales = new int[2 * n];
        hills = new int[2 * n];
        queens = new int[n];
        traceBack(n, 0, res);
        return res;
    }

    private void traceBack(int n, int row, List<List<String>> res) {
        if (n == row)  {
            addSolution(res);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isOkPos(row, i, n)) {
                setQueen(row, i, n);
                traceBack(n, row + 1, res);
                removeQueen(row, i, n);
            }
        }
    }

    private void setQueen(int i, int j, int n) {
        col[j] = 1;
        hills[i + j] = 1;
        dales[i - j + n] = 1;
        queens[i] = j;
    }

    private void removeQueen(int i, int j, int n) {
        col[j] = 0;
        hills[i + j] = 0;
        dales[i - j + n] = 0;
        queens[i] = 0;
    }

    private boolean isOkPos(int i, int j, int n) {
        return col[j] + hills[i + j] +  dales[i - j + n] == 0;
    }

    private void addSolution(List<List<String>> res) {
        StringBuilder sb = new StringBuilder();
        List<String> resItem = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                sb.append(queens[i] == j ? "Q" : ".");
            }
            resItem.add(sb.toString());
            sb = new StringBuilder();
        }
        res.add(resItem);
    }
}
// @lc code=end

