class Solution {
    public int removeDuplicates(int[] nums) {
        int after = 1;
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        for(int iterator = 1; iterator < nums.length ; iterator++){
            if(nums[iterator] > nums[iterator-1]){
                nums[after] = nums[iterator];
                after++;
            }
        }
        return after;
    }
}