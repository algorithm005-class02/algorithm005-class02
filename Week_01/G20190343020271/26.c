//
//  26.c
//  C
//
//  Created by liuk on 2019/12/15.
//  Copyright © 2019 glodon. All rights reserved.
//

#include "26.h"
int removeDuplicates(int *nums,int numsSize){
    if (numsSize==0 || numsSize==1) return numsSize;
    //k为计数器，计算新表里面不相同元素的个数
    int k=1;
    for (int i=1;i<numsSize;i++){
        if (nums[i]!=nums[i-1]){
            nums[k++]=nums[i];
        }
    }
    
//    for(int i = 0 ;i < numsSize; i++){
//        printf("%d ",nums[i]);
//    }

    return k;
}
