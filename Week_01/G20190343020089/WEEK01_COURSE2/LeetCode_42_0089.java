import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 0, right = 0, leftH = 0, rightH = 0, barArea = 0;
        for (int i = 0; i < height.length; i++) {
            leftH = Math.max(leftH, height[i]);
            left += leftH;
            rightH = Math.max(rightH, height[height.length-1-i]);
            right += rightH;
            barArea += height[i];
        }
        return right + left - height.length * leftH - barArea;
    }
}
// @lc code=end

