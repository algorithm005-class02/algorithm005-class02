/**
 * N皇后II
 * https://leetcode.com/problems/n-queens-ii/
 */
public class Leetcode_52_nQueensII {
    /**
     * 方法1：回溯
     */
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0;

        helper(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);

        return count;
    }

    private void helper(int n,
                        int row,
                        boolean[] usedCols,
                        boolean[] usedMains,
                        boolean[] usedMinors) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCols[col] || usedMains[row + col] || usedMinors[row - col + n - 1]) {
                continue;
            }

            usedCols[col] = true;
            usedMains[row + col] = true;
            usedMinors[row - col + n - 1] = true;
            helper(n, row + 1, usedCols, usedMains, usedMinors);

            usedCols[col] = false;
            usedMains[row + col] = false;
            usedMinors[row - col + n - 1] = false;
        }
    }

    /**
     * 方法2：位运算
     */

    public int totalNQueens2(int n) {
        count = 0;

        helper(n, 0, 0, 0, 0);

        return count;
    }

    private void helper(int n,
                        int row,
                        int usedCols,
                        int usedMains,
                        int usedMinors) {
        if (row == n) {
            count++;
            return;
        }

        int bits = (~ (usedCols | usedMains | usedMinors)) & ((1 << n) -1);
        while (bits != 0) {
            int p = bits & - bits;
            bits &= bits - 1;
            helper(n, row + 1, usedCols | p, (usedMains | p) << 1, (usedMinors | p) >> 1);
        }
    }


    public static void main(String[] args) {
        Leetcode_52_nQueensII solution = new Leetcode_52_nQueensII();
        System.out.println(solution.totalNQueens(4));
    }
}
