import java.util.ArrayList;
import java.util.List;

/**
 * 集合的所有子集
 * https://leetcode.com/problems/subsets/
 */
public class Leetcode_78_subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private static void helper(int[] nums, int level, List<List<Integer>> res, List<Integer> path) {
        if (level == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        helper(nums, level + 1, res, path);
        path.add(nums[level]);
        helper(nums, level + 1, res, path);

        path.remove(path.size()-1);
    }
}
