package org.crayzer.leetcode.editor.en.sort.advanced_sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >>> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
        // 也可以⽤ System.arraycopy(a, start1, b, start2, length)
        // temp[k++] = arr[i++];
    }
}
