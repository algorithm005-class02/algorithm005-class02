package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_53_MaximumSubarray {
    class Solution3 {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;

            int[] dp = new int[len];
            dp[0] = nums[0];

            for (int i = 0; i < len; i++) {
                if (dp[i - 1] >= 0) dp[i] = dp[i - 1] + nums[i];
                else dp[i] = nums[i];
            }
            // 或者如下：
            // for (int i = 1; i < len; i++) {
            //     dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // }

            int res = dp[0];
            for (int i = 1; i < len; i++) {
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }

    // 暴力求解 O(n^2)
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < len; i++) {
                int sum = 0;
                // 事实上，只需要枚举子序的左端点，然后再扫描右端点，
                // 因为是求区间和，例如计算 [1, 4] 可以在 [1, 3] 的基础上加上 nums[4] 得到。
                for (int j = i; j < len; j++) {
                    sum += nums[j];
                    max = Math.max(max, sum);
                }
            }
            return max;
        }
    }

    // 暴力求解 O(n^3)
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j <= i; j++) {
                    int sum = sumOfSubArray(nums, j, i);
                    res = Math.max(res, sum);
                }
            }
            return res;
        }

        private int sumOfSubArray(int[] nums, int left, int right) {
            // 子区间的和
            int res = 0;
            for (int i = left; i <= right; i++) {
                res += nums[i];
            }
            return res;
        }
    }
}
