import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Leetcode_1_twoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}
