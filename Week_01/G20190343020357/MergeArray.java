package com.array.review;

import java.util.Arrays;

public class MergeArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        int p1 = 0;
        int p2 = 0;

        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (copy[p1] < nums2[p2] ? copy[p1++] : nums2[p2++]);
        }
        if (p1 < m) {
            System.arraycopy(copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }


    }

    public static void main(String[] args) {

    }
}
