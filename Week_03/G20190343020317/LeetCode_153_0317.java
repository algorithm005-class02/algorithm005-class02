class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[0]) {
                if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }
        return nums[0];
    }
}