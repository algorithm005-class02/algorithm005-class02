package org.crayzer.leetcode.editor.en.array;

public class LeetCode_283_MoveZeroes {

    class Solution2 {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];

                    if (i != index) {
                        nums[i] = 0;
                    }
                }
                index++;
            }
        }
    }

    class Solution1 {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[index++] = num;
                }
            }

            while (index < nums.length) {
                nums[index++] = 0;
            }
        }
    }
}
