/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    printf("digitsSize:%d\n",digitsSize);
    for(int i = digitsSize -1 ; i >= 0; i--){
        digits[i] ++;
        digits[i] = digits[i] % 10;
        if(digits[i] != 0) {
            int* returnarray = (int*) malloc(digitsSize * sizeof(int));
            for(int j = 0; j<digitsSize;j++){
                returnarray[j] = digits[j];
                printf("returnSize[%d]:%d\n",j,returnarray[j]);
            }
            *returnSize = digitsSize;
            printf("now:%d\n",i);
            return returnarray;
        }
        printf("now:%d\n",i);
    }
    *returnSize = digitsSize+1;
    int* returnarray2 = (int*) malloc((digitsSize+1) * sizeof(int));
    for(int i = 1; i<digitsSize+1;i++){
        returnarray2[i] = 0;
    }
    returnarray2[0] = 1;
    return returnarray2;
    
}