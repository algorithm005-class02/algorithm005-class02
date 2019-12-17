
/*
 * 思路：
 * 1、从头到尾遍历，遇到0时计数，然后将后面的往前移动，最后补0.时间复杂度n平方
 * 2、遇到0就和后面非0交换，用两个指针，一个表示当前搜索位置，另一个指向非0数。
 */
void swap(int* nums,int a, int b){
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
}

void moveZeroes(int* nums, int numsSize){
    int i,j,m;
    m = 0;
    for(i=0; i<numsSize; i++){
        if(nums[i]==0){
            for(j=m;j<numsSize;j++){
                if(nums[j]!=0){
                    m = j + 1;
                    swap(nums,i,j);
                    break;
                }
            }
        }
        else{
            m = i+1;
        }
    }
}

