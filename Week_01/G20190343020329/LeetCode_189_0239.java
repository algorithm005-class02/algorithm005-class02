class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length <= 1) {
            return;
        }
        for (int j = 1; j <= k; j++) {
            int num = nums[0];
            int over = 0;
            for (int i = 1; i < nums.length; i ++) {
                over = nums[i];
                nums[i] = num;
                num = over;
            }
            nums[0] = num;
        }
    }
}