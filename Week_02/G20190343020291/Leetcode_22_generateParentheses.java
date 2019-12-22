import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Leetcode_22_generateParentheses {
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
}
