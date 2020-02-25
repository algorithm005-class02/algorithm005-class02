/**
 * 最大子序列和
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Leetcode_53_maximumSubarray {
    /**
     * DP
     * O(n)空间复杂度，存储DP状态
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int res = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = nums[i-1] + Math.max(dp[i - 1], 0);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * DP
     * O(1)空间复杂度
     */
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int cur = 0;
        for (int i = 1; i <= nums.length; i++) {
            cur = nums[i-1] + Math.max(cur, 0);
            res = Math.max(cur, res);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Leetcode_53_maximumSubarray solution = new Leetcode_53_maximumSubarray();
        System.out.println(solution.maxSubArray(nums));
    }

}
