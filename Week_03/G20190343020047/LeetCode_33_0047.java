class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[low]) {
                //[6,7,0,1,2,3,4,5]
                if (target < nums[mid] || target >= nums[low]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                //[3,4,5,6,7,0,1,2]
                if (target > nums[mid] || target < nums[low]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}