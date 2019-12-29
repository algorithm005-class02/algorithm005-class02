package com.array.review;

public class PlusOneArray {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + 1;
            if (digit <= 9) {
                digits[i] = digit;
                return digits;
            }
            digits[i] = 0;
        }
        digits= new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int arr[] = {1};
        plusOne(arr);
        System.out.println();
    }
}
