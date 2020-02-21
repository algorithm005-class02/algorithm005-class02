import java.util.*;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法
public class LeetCode_51_N皇后_0011 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) return result;

        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Stack<Integer> record = new Stack<>();
        helper(0, n, col, pie, na, record, result);
        return result;
    }

    private void helper(int row, int n,
                        Set<Integer> col,
                        Set<Integer> pie,
                        Set<Integer> na,
                        Stack<Integer> record,
                        List<List<String>> result) {
        //terminator
        if (row == n) {
            result.add(convert(record, n));
            return;
        }

        //process
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !pie.contains(i + row) && !na.contains(i - row)) {
                col.add(i);
                pie.add(i + row);
                na.add(i - row);
                record.push(i);

                helper(row + 1, n, col, pie, na, record, result);

                col.remove(i);
                pie.remove(i + row);
                na.remove(i - row);
                record.pop();
            }
        }
    }

    private List<String> convert(List<Integer> record, int n) {
        List<String> list = new ArrayList<>();
        for (int i : record) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            s.replace(i, i + 1, "Q");
            list.add(s.toString());
        }
        return list;
    }

}
