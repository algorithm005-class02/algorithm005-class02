/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
  int *a;
  int  i, j;

  for (i = 0; i < numsSize - 1; i++) {
    for (j = i + 1; j < numsSize; j++) {
      if (nums[i] + nums[j] == target) {
        a = malloc(sizeof(int) * 2);
        a[0] = i;
        a[1] = j;
        *returnSize = 2;
        return a;
      } 
    }
  }
  *returnSize = 0;
  return NULL;
}
