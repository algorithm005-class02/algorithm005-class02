/**
 * 打家劫舍
 * https://leetcode.com/problems/house-robber/
 */
public class Leetcode_198_houseRobber {
    /**
     * 方法1：二维数组表示状态
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            arr[i][0] = Math.max(arr[i - 1][1], arr[i - 1][0]); // i不偷
            arr[i][1] = arr[i - 1][0] + nums[i - 1];            // i偷
        }
        return Math.max(arr[n][0], arr[n][1]);
    }
    /**
     * 方法2：状态简化
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rob = 0, notRob = 0;
        for (int num : nums) {
            int tmp = rob;
            rob = notRob + num;
            notRob = Math.max(notRob, tmp);
        }
        return Math.max(rob, notRob);
    }
}
