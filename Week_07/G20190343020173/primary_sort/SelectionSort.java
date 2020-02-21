package org.crayzer.leetcode.editor.en.sort.primary_sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        selectionSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void selectionSort(int[] nums) {
        int len = nums.length;
        int minIdx, temp;

        for (int i = 0; i < len - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }

            temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
    }
}
