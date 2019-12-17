package com.array.review;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            int previous = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = previous;
                previous = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
         rotate1(arr, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void rotate1(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        nums=arr;
        System.out.println();
    }
}
