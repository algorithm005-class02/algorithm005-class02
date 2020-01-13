class Solution {
    public int maxSubArray(int[] nums) {
        int MAX = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++ ){
            sum = nums[i] > sum + nums[i] ? nums[i] : sum + nums[i];
            MAX = MAX > sum ? MAX : sum;
        }
        return MAX;
    }
}
