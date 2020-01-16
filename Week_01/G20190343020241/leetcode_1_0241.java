import java.util.HashMap;
import java.util.Map;

/** 解题思路：
 * 	1.两层loop
 * 	2.哈希表,将计算结果用哈希保存
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {

    //time complexity:O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) || map.get(diff) != null) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //time complexity:O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) || map.get(diff) != null) {
                return new int[]{i, map.get(diff)};
            }
        }
        return null;
    }

    //time complexity:O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

