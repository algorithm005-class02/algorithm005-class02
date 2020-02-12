package org.crayzer.leetcode.editor.en.sort.advanced_sort;

import java.util.PriorityQueue;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 6, 1};
        heapSort1(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void heapSort1(int[] array, int len) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            q.add(array[i]);
        }

        for (int i = 0; i < len; i++) {
            array[i] = q.poll();
        }
    }

    //
    public static void heapSort2(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) heapify(array, length, i);

        for (int i = length - 1; i >= 0; i--) {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);

        }
    }

    private static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {

            largest = right;
        }
        if (largest != i) {

            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, length, largest);
        }
    }
}
