class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> expectMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (expectMap.containsKey(nums[i])) {
                return new int[]{expectMap.get(nums[i]), i};
            }
            int exp = target - nums[i];
            expectMap.put(exp, i);
        }
        return new int[]{0, 0};
    }
}