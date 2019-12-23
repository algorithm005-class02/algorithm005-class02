package org.crayzer.leetcode.editor.en.array;

public class Leet_66_Plus_One {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;

            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
