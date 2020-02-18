package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_45_JumpGame2 {
    public int jump(int[] nums) {
        int maxPosition = 0;
        int steps = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
