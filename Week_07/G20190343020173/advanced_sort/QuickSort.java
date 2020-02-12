package org.crayzer.leetcode.editor.en.sort.advanced_sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void quickSort(int[] nums, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: ⼩于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }
}
