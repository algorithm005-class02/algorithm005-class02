package org.crayzer.leetcode.editor.en.sort.special_sort;

public class CountingSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        countingSort(nums, 6);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void countingSort(int[] a, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int len = a.length;
        int bucketLen = maxValue + 1;
        int sortIdx = 0;

        for (int i = 0; i < len; i++) {
            if (bucket[a[i]] == 0) bucket[a[i]] = 0;
            bucket[a[i]]++;
        }

        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                a[sortIdx++] = i;
                bucket[i]--;
            }
        }
    }
}
