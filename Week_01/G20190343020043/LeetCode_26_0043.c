int removeDuplicates(int* nums, int numsSize){
    int prev = 0, curr = 0;
    if (nums == NULL || numsSize < 2) {
        return numsSize;
    } else {
        while (curr < numsSize) {
            if (nums[prev] != nums[curr]) {
                nums[++prev] = nums[curr];
            }
            curr++;
        }
        return ++prev;
    }
}