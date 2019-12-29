/**
 * 解题思路：
 * 用hashMap查询
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //首先把元素都存入
        for(int i = 0;i<nums.length;++i){
            map.put(num[i], i);
        }
        for(int i = 0;i<nums.length;++i){
            int element = target - nums[i];
            if (map.containsKey(element) && map.get(element) != i){
                return new int[]{i, map.get(element)}
            }
        }
    }
}
