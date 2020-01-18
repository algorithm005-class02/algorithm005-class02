import java.util.*;

/**
 * N皇后问题
 * https://leetcode.com/problems/n-queens/
 */
public class Leetcode_51_nQueens {

    /**
     * 方法1：回溯，使用HashSet记录已经占用的列、主对角线、副对角线；
     * Note：主对角线 行号+列号=常数；
     * 副对角线 行号-列号=常数；
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();

        backtrace(n, 0, res, new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());

        return processResult(res, n);
    }


    private static void backtrace(int n,
                                  int row,
                                  List<List<Integer>> res,
                                  List<Integer> path,
                                  Set<Integer> usedCols,
                                  Set<Integer> usedMain,
                                  Set<Integer> usedMinor) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCols.contains(col) || usedMain.contains(row + col) || usedMinor.contains(row - col)) {
                continue;
            }

            path.add(col);
            usedCols.add(col);
            usedMain.add(row + col);
            usedMinor.add(row - col);
            backtrace(n, row + 1, res, path, usedCols, usedMain, usedMinor);

            path.remove(path.size() - 1);
            usedCols.remove(col);
            usedMain.remove(row + col);
            usedMinor.remove(row - col);
        }

    }

    /**
     * 方法2： 回溯法，使用array代替HashSet效率提升一倍，由7ms至3ms
     */
    public static List<List<String>> solveNQueens2(int n) {
        List<List<Integer>> res = new ArrayList<>();

        backtrace(n, 0, res, new ArrayList<>(), new boolean[2 * n - 1], new boolean[2 * n - 1], new boolean[2 * n - 1]);

        return processResult(res, n);
    }


    private static void backtrace(int n,
                                  int row,
                                  List<List<Integer>> res,
                                  List<Integer> path,
                                  boolean[] usedCols,
                                  boolean[] usedMain,
                                  boolean[] usedMinor) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCols[col] || usedMain[row + col] || usedMinor[row - col + n - 1]) {
                continue;
            }

            path.add(col);
            usedCols[col] = true;
            usedMain[row + col] = true;
            usedMinor[row - col + n - 1] = true;

            backtrace(n, row + 1, res, path, usedCols, usedMain, usedMinor);

            path.remove(path.size() - 1);
            usedCols[col] = false;
            usedMain[row + col] = false;
            usedMinor[row - col + n - 1] = false;
        }

    }


    private static List<List<String>> processResult(List<List<Integer>> res, int n) {
        List<List<String>> boards = new ArrayList<>();

        for (List<Integer> re : res) {
            List<String> tmp = new ArrayList<>();
            for (Integer i : re) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                tmp.add(String.valueOf(chars));
            }

            boards.add(tmp);
        }

        return boards;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens2(n));

    }
}
