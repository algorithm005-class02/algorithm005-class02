class Solution {
    public void moveZeroes(int[] nums) {
        // 滚雪球方法，执行用时0ms，内存消耗37.5MB
        int j = 0;//使用j存储是0的位置
        for (int i = 0;i <nums.length;i++){
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}