int* plusOne(int* digits, int digitsSize, int* returnSize){
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        } else {
            digits[i] = 0;
        }
    }
    int* res = malloc((digitsSize + 1) * sizeof(int));
    *returnSize = digitsSize + 1;
    res[0] = 1;
    for (int i = 1; i <= digitsSize; i++) {
        res[i] = 0;
    }
    return res;
}