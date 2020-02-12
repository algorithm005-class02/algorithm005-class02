package org.crayzer.leetcode.editor.en.sort;

public class LeetCode_1122_RelativeSortArray {

    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] temp = new int[1001];
            int[] res = new int[arr1.length];

            for (int i = 0; i < arr1.length; i++) {
                temp[arr1[i]]++;
            }

            int index = 0;
            for (int i = 0; i < arr2.length; i++) {
                while (temp[arr2[i]] > 0) {
                    res[index++] = arr2[i];
                    temp[arr2[i]]--;
                }
            }

            for (int i = 0; i < 1001; i++) {
                while (temp[i] > 0) {
                    res[index++] = i;
                    temp[i]--;
                }
            }
            return res;
        }
    }
}
