int search(int* nums, int numsSize, int target){
    int start = 0;
    int end = numsSize - 1;
    int mid = -1;
    while (start <= end) {
        mid = start + ((end - start) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[start] <= nums[mid]) {//左边有序排列
            if (nums[start] == target) {
                return start;
            } else if (nums[start] < target && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else { //否则，右边有序排列
            if (nums[end] == target) {
                return end;
            } else if (nums[mid] < target && target < nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return -1;
}