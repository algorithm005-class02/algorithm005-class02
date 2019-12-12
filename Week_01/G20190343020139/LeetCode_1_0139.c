/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    int* result = malloc(sizeof(int)*2);
    int i = 0;
    int j = 0;
    int over = 0;
    for(i = 0 ; i < numsSize; i++){
        if(over == 1)
            break;
        for(j = i+1 ; j < numsSize ; j++){
            if(over == 1){
                break;
            }
            if(nums[i] + nums[j] == target){
                result[0] = i;
                result[1] = j;
                over = 1;
                break;
            }
        }        
    }
    return result;  
}