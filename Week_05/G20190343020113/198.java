class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] cur = new int[nums.length];
        cur[0] = nums[0];
        cur[1] = Math.max(nums[0], nums[1]);
        if(nums.length == 2) {
            return cur[1];
        }
        for(int i = 2; i < nums.length;i++) {
            cur[i] = Math.max(nums[i] + cur[i - 2], cur[i - 1]);
        }
        return cur[nums.length - 1];
    }
}