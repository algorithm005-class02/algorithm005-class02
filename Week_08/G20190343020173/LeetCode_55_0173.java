package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_55_JumpGame {

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    // 最佳 贪心算法
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int endReachable = nums.length - 1;

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] + i >= endReachable) endReachable = i;
            }

            return endReachable == 0;
        }
    }

    class Solution1 {
        Index[] memo;
        public boolean canJump(int[] nums) {
            Index[] memo = new Index[nums.length];
            for (int i = 0; i < memo.length; i++) {
                memo[i] = Index.UNKNOWN;
            }
            memo[memo.length - 1] = Index.GOOD;

            for (int i = nums.length - 2; i >= 0; i--) {
                int furthestJump = Math.min(i + nums[i], nums.length - 1);
                for (int j = i + 1; j <= furthestJump; j++) {
                    if (memo[j] == Index.GOOD) {
                        memo[i] = Index.GOOD;
                        break;
                    }
                }
            }
            return memo[0] == Index.GOOD;
        }
    }

    class Solution2 {
        Index[] memo;

        public boolean canJump(int[] nums) {
            memo = new Index[nums.length];
            for (int i = 0; i < nums.length - 1; i++) {
                memo[i] = Index.UNKNOWN;
            }
            memo[nums.length - 1] = Index.GOOD;
            return recursion(0, nums);
        }

        private boolean recursion(int position, int[] nums) {
            if (memo[position] != Index.UNKNOWN) {
                return memo[position] == Index.GOOD ? true : false;
            }
            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (recursion(nextPosition, nums)) {
                    memo[nextPosition] = Index.GOOD;
                    return true;
                }
            }
            memo[position] = Index.BAD;
            return false;
        }
    }

    class Solution3 {
        public boolean canJump(int[] nums) {
            return recursion(0, nums);
        }

        private boolean recursion(int position, int[] nums) {
            if (position == nums.length - 1) return true;
            int furthestJump = Math.min(position + nums[position], nums.length - 1);

            // Old
            // for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            // New
            for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
                if (recursion(nextPosition, nums)) return true;
            }
            return false;
        }
    }
}
