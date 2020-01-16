class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                result[0] = indexMap.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return null;
    }
}
