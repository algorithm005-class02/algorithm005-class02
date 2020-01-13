class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        if(nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robSub(nums, 0, nums.length - 1), Math.max(robSub(nums, 1, nums.length - 1), robSub(nums, 1, nums.length)));
    }
    public int robSub(int[] nums, int left, int right) {
        if(right - left < 1) {
            return 0;
        }
        if(right - left < 2) {
            return nums[left];
        }
        int[] cur = new int[right - left];
        cur[0] = nums[left];
        cur[1] = Math.max(nums[left], nums[left + 1]);
        for(int i = left + 2;i < right;i++) {
            cur[i - left] = Math.max(nums[i] + cur[i - left - 2], cur[i - left - 1]);
        }
        return cur[right - left - 1];
    }
}