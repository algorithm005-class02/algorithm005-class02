import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * https://leetcode.com/problems/combinations/
 */
public class Leetcode_77_combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            comb.add(i);
            helper(res, comb, i+1, n, k-1);
            comb.remove(comb.size() - 1);
        }
    }
}
