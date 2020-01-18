int jump(int* nums, int numsSize) {
    int step = 0, max = 0, end = 0, tmp = 0;
    for (int i = 0; i < numsSize - 1; i++) {
        tmp = i + nums[i];
        max = (tmp > max ? tmp : max);
        if (i == end) {
            step++;
            end = max;
        }
    } 
    return step;
}