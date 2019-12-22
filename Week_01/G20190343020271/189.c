//
//  189.c
//  C
//
//  Created by liuk on 2019/12/15.
//  Copyright © 2019 glodon. All rights reserved.
//

#include "189.h"
void rotate(int* nums, int numsSize, int k){

    int *ret = (int *)malloc(sizeof(int)*numsSize);
    for (int i = 0 ; i < numsSize; i++){
        ret[(i + k) % numsSize] = nums[i];
    }
    memcpy(nums,ret,sizeof(int)*numsSize);
    
//    for(int i = 0 ;i < numsSize; i++)
//    {
//        printf("%d ",nums[i]);
//    }
    return;
}

