class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> record = new HashMap<>();
       for (int i = 0; i < nums.length; ++i) {
           Integer a = record.get(target - nums[i]);
           if (a != null) {
               return new int[] {a, i};
           }
           record.put(nums[i], i);
       }
       return new int[0];
    }
}
