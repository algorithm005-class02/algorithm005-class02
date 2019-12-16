void moveZeroes(int* nums, int numsSize){
  int zeroIndex, i;
  
  for (i = 0, zeroIndex = 0 ; i < numsSize; i++) {
    if (nums[i] != 0) {
      nums[zeroIndex++] = nums[i];
    }
  }
  while (zeroIndex < numsSize )
    nums[zeroIndex++] = 0;
}
