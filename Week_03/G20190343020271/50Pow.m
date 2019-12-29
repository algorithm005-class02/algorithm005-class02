//
//  50Pow.m
//  Algorithm
//
//  Created by liuk on 2019/12/24.
//  Copyright © 2019 glodon. All rights reserved.
//

#import "50Pow.h"

@implementation _0Pow
- (float)pow:(float)x n:(NSInteger)n{
    if (n < 0) {
        n = -n;
        x = 1 / x;
    }
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return x;
    }
    float result = [self pow:x n:n / 2];
    if (n % 2 == 0) {
        return result *result;
    }else{
        return result * result * x;
    }
    
}
@end
