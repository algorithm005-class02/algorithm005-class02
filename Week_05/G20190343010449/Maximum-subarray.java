class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > 0){
                nums[i] = nums[i] + nums[i-1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}