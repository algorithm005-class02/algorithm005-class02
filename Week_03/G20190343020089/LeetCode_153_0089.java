/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        if(nums[hi] > nums[lo]) return nums[0];
        while (lo < hi) {
            // 最后两个值可以排除左边的，所以选择左中位数
            mid = (lo + hi) >> 1;
            if (nums[mid] >= nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            } 
        }
        return nums[lo];
        
    }
}
// @lc code=end

