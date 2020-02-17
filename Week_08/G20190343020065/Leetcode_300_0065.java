public class Leetcode_300_0065 {
    //动态规划解法
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)  return 0;
        int[] dp = new int[nums.length];
        int result = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1)    ;
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
