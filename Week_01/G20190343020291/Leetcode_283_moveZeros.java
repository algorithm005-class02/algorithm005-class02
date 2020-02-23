/**
 * 移动零
 * https://leetcode.com/problems/move-zeroes/
 */
class Leetcode_283_moveZeros {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}