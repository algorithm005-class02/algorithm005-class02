import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LeeCode_1_0321 {
    /**
     * Two Sum
     * 两数之和
     */
    public static void main(String[] args) {
        int[] twoSum = new Solution().twoSum(new int[]{2, 4, 7, 9, 4}, 16);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int numLeft = target - nums[i];
            if (map.containsKey(numLeft)) {
                return new int[]{map.get(numLeft),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution is found.");
    }
}