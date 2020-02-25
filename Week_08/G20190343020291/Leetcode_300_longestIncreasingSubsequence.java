/**
 * 最长上升子序列
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Leetcode_300_longestIncreasingSubsequence {
    /**
     * 方法1： DP
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ret = 1;
        for (int i = 1; i < n; i++) {
            int tmpMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmpMax = Math.max(tmpMax, dp[j]);
                }
            }
            dp[i] = tmpMax + 1;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
    /**
     * 方法2： Patience Sorting
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) >> 1;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }
}
