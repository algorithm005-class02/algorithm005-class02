/**
 * 打家劫舍II
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Leetcode_213_houseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            int n = nums.length;
            return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
        }
    }

    private int helper(int[] nums, int i, int j) {
        int rob = 0, notRob = 0;
        for (int k = i; k <= j; k++) {
            int tmp = rob;
            rob = notRob + nums[k];
            notRob = Math.max(tmp, notRob);
        }
        return Math.max(rob, notRob);
    }

}
