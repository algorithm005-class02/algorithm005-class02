void moveZeroes(int* nums, int numsSize){
    if (nums != NULL && numsSize > 1) {
        int j = 0;
        for (int i = 0; i < numsSize; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}