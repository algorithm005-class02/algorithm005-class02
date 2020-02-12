package org.crayzer.leetcode.editor.en.sort;

import java.util.Arrays;

public class LeetCode_493_ReversePairs {

    class Solution2 {
        public int ret;

        public int reversePairs(int[] nums) {
            ret = 0;
            mergeSort(nums, 0, nums.length - 1);
            return ret;
        }

        public void mergeSort(int[] nums, int left, int right) {
            if (right <= left) {
                return;
            }
            int middle = left + (right - left) / 2;
            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);

            //count elements
            int count = 0;
            for (int l = left, r = middle + 1; l <= middle; ) {
                if (r > right || (long) nums[l] <= 2 * (long) nums[r]) {
                    l++;
                    ret += count;
                } else {
                    r++;
                    count++;
                }
            }

            //merge sort
            int[] temp = new int[right - left + 1];
            for (int l = left, r = middle + 1, k = 0; l <= middle || r <= right; ) {
                if (l <= middle && ((r > right) || nums[l] < nums[r])) {
                    temp[k++] = nums[l++];
                } else {
                    temp[k++] = nums[r++];
                }
            }
            for (int i = 0; i < temp.length; i++) {
                nums[left + i] = temp[i];
            }
        }
    }
}

class Solution1 {
    public int ret;

    public int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);

        //count elements
        int count = 0;
        for (int l = left, r = middle + 1; l <= middle; ) {
            if (r > right || (long) nums[l] <= 2 * (long) nums[r]) {
                l++;
                ret += count;
            } else {
                r++;
                count++;
            }
        }
        //sort
        Arrays.sort(nums, left, right + 1);
    }

    class Solution {
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            if (left >= right) return 0;
            int mid = (left + right) >>> 1;
            int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            for (int i = left, j = mid + 1; i <= mid; i++) {
                while (j <= right && nums[i] / 2.0 > nums[j]) j++;
                cnt += j - (mid + 1);
            }
            Arrays.sort(nums, left, right + 1);
            return cnt;
        }
    }
}
