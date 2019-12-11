/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left_max = 0;
        int right_max = 0;
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                // (height[left])>=(left_max)?left_max=height[left]:ans+=left_max-height[left];
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans = ans + (left_max - height[left]);
                }
                left++;
            } else {
                // height[right]>=right_max?right_max=height[right]:ans+=right_max-height[right];
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans = ans + (right_max - height[right]);
                }
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end
/* 
思路：
    双指针法
    初始化两个指针，一个指向最左边:0，一个指向最右边：height.length-1。
    初始化左右的两个最大高度值left_max=0;right_max=0;
    我们的主旨是：先整体宏观的来看，左右两侧积水的高度，取决于左右两侧中较低的柱子；
    （1）如果左侧的柱子低，那么我们考虑左边，看左指针指向的高度与左边的最大值谁大谁小，
    如果当前左指针的高度高于了左侧最大值，那么更新左指针的高度值为左侧的最大值；
    否则计算左侧最大值left_max与左指针之间的高度差为积水量；
    左指针++；
    （2）如果右侧的柱子高度低的话，那么我们考虑右侧的情况：
    如果当前右指针的高度高于了右侧最大值，那么我么更新右侧最大值当前右指针指向的值，
    否则计算右侧最大值right_max与右指针之间的高度差值为积水量；
    右指针--；
    时间复杂度：O（1）
*/