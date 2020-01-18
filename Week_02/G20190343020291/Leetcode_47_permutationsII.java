import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 * https://leetcode.com/problems/permutations-ii/
 */
public class Leetcode_47_permutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }


    private void helper(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used) {
        if (nums.length == perm.size()) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            perm.add(nums[i]);
            helper(res, perm, nums, used);

            used[i] = false;
            perm.remove(perm.size() - 1);
        }

    }
}
