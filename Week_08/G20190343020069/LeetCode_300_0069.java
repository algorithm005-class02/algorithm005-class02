package leetcode.week08;

public class LeetCode_300_0069 {
    /**
     * 求最大自增子序列的长度
     * @param nums
     * @return
     */
    public static int lenthOfLIS (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxns = 1;
        for (int i = 1; i < nums.length; i++){
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval , dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxns = Math.max(maxns, dp[i]);
        }
        return maxns;
    }

    public static int sumLIS (int[] nums , int lisLen) {
        int[] sumArr = new int[lisLen];
        int res = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++){
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                   sumArr[j] = nums[j];
                }
            }
        }
        for (int item : sumArr) {
            res += item;
        }
        return res;
    }

    public static void main (String args[]) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = lenthOfLIS(nums);
        int res = sumLIS(nums , len);
        System.out.println(lenthOfLIS(nums));
        System.out.println("最长子序列的和为"+res);
    }
}
