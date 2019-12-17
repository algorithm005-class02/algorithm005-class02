
int* twoSum(int* nums, int numsSize, int target, int* returnSize){

    int finSize = 0;

    int* returnArray = (int *)malloc(numsSize*sizeof(int));
    for(int i=0;i < numsSize-1;++i){
        for(int j=i+1;j < numsSize;++j){
            if(nums[i]+nums[j] == target){
                returnArray[finSize] = i;
                ++finSize ;
                returnArray[finSize] = j;
                ++finSize ;
            }
        }
    }

    *returnSize = finSize;
    return returnArray;
}

