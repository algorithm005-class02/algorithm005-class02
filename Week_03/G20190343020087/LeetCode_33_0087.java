/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 * 二分查找，
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) return mid;
            // mid左边为升序
            if (nums[left] <= nums[mid]) { 
                // 目标值小于中间值，在中间值左边
                if (target >= nums[left] && target <= nums[mid]) {right = mid - 1;}
                // 否则目标值只能在右边找
                else left = mid + 1;
            }
            // mid 右边为升序
            else {
                // 目标值在右边范围内
                if (target >= nums[mid] && target <= nums[right]) {left = mid + 1;}
                // 右边没有在左边找
                else right = mid - 1;        
            }
            // 重置中间值
            mid = left + (right - left) / 2;
        }
        return -1; // 没找到
    }
}
// @lc code=end
