int* plusOne(int* digits, int digitsSize, int* returnSize){
    int* res = NULL;
    *returnSize = 0;
    int m = -1;
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            m = i;
            break;
        }
    }
    if (m == -1) {
        res = malloc((digitsSize + 1) * sizeof(int));
        *returnSize = digitsSize + 1;
        res[0] = 1;
        for (int i = 1; i <= digitsSize; i++) {
            res[i] = 0;
        }
        return res;
    } else {
        res = malloc(digitsSize * sizeof(int));
        *returnSize = digitsSize;
        res[m] = digits[m] + 1;
        for ( int i = 0; i < m; i++) {
            res[i] = digits[i];
        }
        for ( int i = m + 1; i < digitsSize; i++) {
            res[i] = 0;
        }
        return res;
    }
}