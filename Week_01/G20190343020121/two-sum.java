import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compent = target - nums[i];
            if (map.containsKey(compent)) {
                return new int[]{ map.get(compent), i};
            }
            map.put(nums[i] , i) ;
        }
        throw  new IllegalArgumentException("没有解法");


    }
}