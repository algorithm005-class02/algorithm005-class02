package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_198_HouseRobber {

    class Solution1 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int n = nums.length;
            int[] a = new int[n];

            a[0] = nums[0];
            a[1] = Math.max(nums[0], nums[1]);
            int res = Math.max(a[0], a[1]);
            for (int i = 2; i < n; ++i) {
                a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
                res = Math.max(res, a[i]);
            }
            return res;
        }
    }

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int[][] a = new int[n][2];

            a[0][0] = 0;
            a[0][1] = nums[0];

            for (int i = 1; i < n; i++) {
                a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
                a[i][1] = a[i - 1][0] + nums[i];
            }
            return Math.max(a[n - 1][0], a[n - 1][1]);
        }
    }
}
