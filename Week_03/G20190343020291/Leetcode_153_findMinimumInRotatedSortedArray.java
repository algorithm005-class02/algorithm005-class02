/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Leetcode_153_findMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
