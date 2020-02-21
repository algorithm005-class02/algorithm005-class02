import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {

    private int[] hills, dales, col, queens;
    
    public List<List<String>> solveNQueens(int n) {
        hills = new int[n << 1];
        dales = new int[n << 1];
        col = new int[n];
        queens = new int[n];
        List<List<String>> res = new ArrayList<>();
        traceBack(0, n, res);
        return res;
    }


    private void traceBack(int i, int n, List<List<String>> res) {
        if (i == n) {
            addSolution(res);  
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isOkPos(i, j, n)) {
                setQueen(i, j, n);
                traceBack(i + 1, n, res);
                removeQueen(i, j, n);
            } 
        }
    }

    private boolean isOkPos(int i, int j, int n) {
        return col[j] + hills[i + j] + dales[i - j + n] == 0;
    }

    private void setQueen(int i , int j, int n) {
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

    private void addSolution(List<List<String>> res) {
        List<String> resItem = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
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

