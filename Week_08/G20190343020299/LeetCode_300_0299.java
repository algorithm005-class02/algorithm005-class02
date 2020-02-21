/**
 * 300. 最长上升子序列
 */
public class LeetCode_300_0299 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int res = new LeetCode_300_0299().lengthOfLIS(nums);
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int curMax = 1;

        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    maxVal = Math.max(maxVal, dp[j]);
            }
            dp[i] = maxVal + 1;
            curMax = Math.max(curMax, dp[i]);
        }
        return curMax;
    }
}
