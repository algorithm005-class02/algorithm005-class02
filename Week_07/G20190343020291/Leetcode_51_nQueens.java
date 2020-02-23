import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 * https://leetcode.com/problems/n-queens/
 */
public class Leetcode_51_nQueens {
    /**
     * 方法1：回溯
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();

        helper(n, 0, res, new ArrayList<>(), new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);

        return processResult(n, res);
    }

    private void helper(int n,
                        int row,
                        List<List<Integer>> res,
                        List<Integer> path,
                        boolean[] usedCols,
                        boolean[] usedMains,
                        boolean[] usedMinors) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCols[col] || usedMains[row + col] || usedMinors[row - col + n - 1]) {
                continue;
            }

            path.add(col);
            usedCols[col] = true;
            usedMains[row + col] = true;
            usedMinors[row - col + n - 1] = true;
            helper(n, row + 1, res, path, usedCols, usedMains, usedMinors);

            path.remove(path.size() - 1);
            usedCols[col] = false;
            usedMains[row + col] = false;
            usedMinors[row - col + n - 1] = false;
        }
    }

    private List<List<String>> processResult(int n, List<List<Integer>> res) {
        List<List<String>> boards = new ArrayList<>();
        for (List<Integer> list : res) {
            List<String> tmp = new ArrayList<>();
            for(Integer i : list) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                tmp.add(String.valueOf(chars));
            }
            boards.add(tmp);
        }
        return boards;
    }

}
