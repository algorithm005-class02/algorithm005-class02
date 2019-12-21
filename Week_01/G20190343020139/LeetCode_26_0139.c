int removeDuplicates(int* nums, int numsSize){
    int i,j = 0;
    if(numsSize <= 1) return numsSize;
    for(i = 1; i< numsSize; i++ ){
        if(nums[j] != nums[i]){
            nums[++j] = nums[i];
        }
    }
 //   for(i=j+1;i<numsSize;i++){
 //       nums[i] = 0;
 //   }
    return j+1;
}