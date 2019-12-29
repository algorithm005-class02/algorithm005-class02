class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null)
            return false;
        int length = nums.length - 1;
        for(int i = length; i>=0; i--){
            if(nums[i]+i >= length){
                length = i;                
            }
        }
        return length == 0;
    }
}