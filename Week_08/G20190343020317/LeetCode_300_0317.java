class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int [] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i<len; i++){
            int maxans = 0;
            for(int j = 0; j< i; j++ ){
                if(nums[i]>nums[j]){
                    maxans = Math.max(maxans, dp[j]);
                }
            }
            dp[i] = maxans+1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}