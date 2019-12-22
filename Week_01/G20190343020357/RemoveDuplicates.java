package com.array.review;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i + 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int index = nums.length > 0 ? 1 : 0;
        for (int temp : nums) {
            if (temp > nums[index - 1]) {
                nums[index++] = temp;
            }
        }
        return index;
    }

    public static int removeDuplicates2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int n : nums) {
            if (index == 0 || nums[index - 1] < n) {
                nums[index] = n;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates2(arr);
    }
}
