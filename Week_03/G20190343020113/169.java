class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null) return -1;
        if(nums.length == 1) return nums[0];
        for(int j = 0;j < nums.length;j++) {
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[j] == nums[i]) {
                    count++;
                }
                if(count > nums.length / 2)  {
                    return nums[j];
                }
            }
        }
        return -1;
    }
}