package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.Arrays;

public class LeetCode_213_HouseRobber2 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int n = nums.length;
            return Math.max(myrob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    myrob(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int myrob(int[] nums) {
            int preMax = 0;
            int curMax = 0;
            for (int x : nums) {
                int temp = curMax;
                curMax = Math.max(preMax + x, curMax);
                preMax = temp;
            }
            return curMax;
        }
    }
}
