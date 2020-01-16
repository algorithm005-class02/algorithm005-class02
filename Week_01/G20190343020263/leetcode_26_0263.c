int removeDuplicates(int* nums, int numsSize){
  int i, j ,k;

  k = numsSize;

  for (i = 0 ; i < k - 1; i++) {
    for (j = i + 1; j < k; j++) {
      if (nums[i] == nums[j])
        continue;
      else
        break;
    }
    if (j != i + 1) {
      memmove(&nums[i+1], &nums[j], (k-j) * sizeof(int));
      k -= j - i - 1;
    }
  }
  return i + 1;
}
