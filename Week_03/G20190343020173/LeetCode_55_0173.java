package org.crayzer.leetcode.editor.en.greedy;

public class LeetCode_55_JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) return false;
            int endReachable = nums.length - 1;
            for (int i = nums.length - 1; i >= 0 ; i--) {
                if (nums[i] + i >= endReachable) endReachable = i;
            }

            return endReachable == 0;
        }
    }
}
