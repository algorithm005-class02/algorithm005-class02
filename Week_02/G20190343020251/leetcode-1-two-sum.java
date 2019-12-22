class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two such nums");
    }
}
