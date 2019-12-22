void moveZeroes(int* nums, int numsSize){

    int zeroNums = 0;
    for(int cnt=0;cnt < numsSize; ++cnt){
        if(nums[cnt] == 0){
            ++zeroNums;
        }
        else if(zeroNums > 0){
            nums[cnt-zeroNums]=nums[cnt];
            nums[cnt]=0;
        }
    }

}
