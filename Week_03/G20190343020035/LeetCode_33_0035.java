
public class LeetCode_33_0035{
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int hight = nums.length - 1;
        int mid;
        while (low <= hight) {
            mid = low + (hight - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[hight] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }

        }
        return -1;
    }
}

