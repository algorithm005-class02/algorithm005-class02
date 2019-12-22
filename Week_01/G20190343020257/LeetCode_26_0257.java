class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int r = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[r] != nums[i]) {
                ++r;
                nums[r] = nums[i];
            }
        }
        return r+1;
    }
}
