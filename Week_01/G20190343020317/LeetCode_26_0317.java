class Solution {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        int j = 1;
        while (j<nums.length){
            if (nums[j] == nums[i]){
                result--;
            }
            else {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return result;
    }
}