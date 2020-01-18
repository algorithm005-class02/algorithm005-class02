/**
 * 搜索旋转排序数组
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Leetcode_33_searchInRotatedSortedArray {

    /**
     * 方法1： 直接二分查找
     * 判断条件是根据哪一半是有序的
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 方法2：2次二分查找
     * 先二分查找到旋转的索引位置，再在有序的一侧上进行二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int index = findRotatedIndex(nums);
        int left = 0, right = nums.length - 1;
        left = target <= nums[right] ? index : left;
        right = target > nums[right] ? index - 1 : right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findRotatedIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
