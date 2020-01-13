import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Leetcode_22_generateParentheses {

    /**
     * 方法1：回溯法
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int left, int right, int n, String str, List<String> res) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, str + "(", res);
        }

        if (right < left) {
            generate(left, right + 1, n, str + ")", res);
        }
    }

    /**
     * 方法2：DFS
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, "", res);
        return res;
    }

    private void dfs(int left, int right, int n, String str, List<String> res) {
        if (left < right) {
            return;
        }

        if (left == n && right == n) {
            res.add(str);
            return;
        }

        if (left < n) {
            dfs(left + 1, right, n, str + "(", res);
        }

        if (right < n) {
            dfs(left, right + 1, n, str + ")", res);
        }
    }
}
