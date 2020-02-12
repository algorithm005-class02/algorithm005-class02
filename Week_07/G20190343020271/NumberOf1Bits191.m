//
//  NumberOf1Bits191.m
//  Algorithm
//
//  Created by liuk on 2020/2/9.
//  Copyright © 2020 glodon. All rights reserved.
//

#import "NumberOf1Bits191.h"

@implementation NumberOf1Bits191
int hammingWeight(uint32_t n) {
    int sum = 0;
    while(n != 0){
        sum++;
        n = n & (n - 1);
    }
    return sum;
}
@end
