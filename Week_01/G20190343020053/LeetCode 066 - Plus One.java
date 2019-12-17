class Solution {
    public int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        while (last >= 0 && digits[last] == 9) {
            digits[last] = 0;
            last--;
        }
        if (last == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            digits[last]++;
            return digits;
        }
    }
}