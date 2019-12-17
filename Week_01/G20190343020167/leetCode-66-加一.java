class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int[] newDigits = new int[digits.length + 1];
                    for (int j = 0; j < newDigits.length; j++) {
                        if (j == 0) {
                            newDigits[j] = 1;
                        } else {
                            newDigits[j] = 0;
                        }
                    }
                    return newDigits;
                }
                continue;
            }
        }
        return digits;
    }
}