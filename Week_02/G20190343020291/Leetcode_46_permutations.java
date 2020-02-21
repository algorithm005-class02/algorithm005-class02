import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * https://leetcode.com/problems/permutations/
 */
public class Leetcode_46_permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> perm, int[] nums) {
        if (nums.length == perm.size()) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (perm.contains(nums[i])) {
                continue;
            }

            perm.add(nums[i]);
            helper(res, perm, nums);
            perm.remove(perm.size() - 1);
        }
    }
}
