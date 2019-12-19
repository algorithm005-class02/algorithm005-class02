class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int numOfZeroes = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                numOfZeroes++;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = len - numOfZeroes; i < len; i++) {
            nums[i] = 0;
        }
    }
}