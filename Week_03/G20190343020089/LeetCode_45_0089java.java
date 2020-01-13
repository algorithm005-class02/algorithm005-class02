/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    
    public int jump(int[] nums) {
    
        int end = 0, maxPos = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps; 
    }

}
// @lc code=end

