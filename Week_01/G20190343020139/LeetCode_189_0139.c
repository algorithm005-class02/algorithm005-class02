void rotate(int* nums, int numsSize, int k){
    int temp;
    for(int i = 0; i < k; i++){
        temp = nums[numsSize-1];
        for(int j = numsSize-1; j > 0 ; j--){
            nums[j] = nums[j-1];
        }
        nums[0] = temp;
    }
}