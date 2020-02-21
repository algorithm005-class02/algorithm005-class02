package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_152_MaximumProductSubarray {

    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length, res = nums[0], l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                l = (l == 0 ? 1 : l) * nums[i];
                r = (r == 0 ? 1 : r) * nums[n - 1 - i];
                res = Math.max(res, Math.max(l, r));
            }
            return res;
        }
    }

    class Solution1 {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if (nums == null || len == 0) return 0;
            int res = nums[0];
            int preMax = nums[0];
            int preMin = nums[0];

            for (int i = 1; i < len; i++) {
                int curMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
                int curMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
                res = Math.max(res, curMax);
                preMax = curMax;
                preMin = curMin;
            }
            return res;
        }
    }
}
