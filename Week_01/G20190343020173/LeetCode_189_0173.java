package org.crayzer.leetcode.editor.en.array;

public class LeetCode_189_RotateArray {

    class Solution2 {
        public void rotate(int[] nums, int k) {
             k = k % nums.length;

            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k-1);
            reverse(nums, k+1, nums.length-1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    /**
     * 不符合题目要求，要求原地算法
     * 典型的空间换时间算法
     */
    class Solution1 {
        public void rotate(int[] nums, int k) {
            int[] tempArr = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                tempArr[(i + k) % nums.length] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = tempArr[i];
            }
        }
    }

    // class Solution {
    //     public void rotate(int[] nums, int k) {
    //         int temp, previous;
    //         for (int i = 0; i < k; i++) {
    //
    //             previous = nums[nums.length - 1];
    //             for (int j = 0; j < nums.length; j++) {
    //                 temp = nums[j];
    //                 nums[j] = previous;
    //                 previous = temp;
    //             }
    //         }
    //     }
    // }
}
