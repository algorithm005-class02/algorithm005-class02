//
//  1TwoSum.m
//  Algorithm
//
//  Created by liuk on 2019/12/22.
//  Copyright © 2019 glodon. All rights reserved.
//

#import "1TwoSum.h"

@implementation _TwoSum
- (NSArray *)twoSum:(NSArray <NSNumber *>*)array target:(int)target{
    NSMutableDictionary *dic = [@{} mutableCopy];
    for (NSInteger i = 0; i < array.count; i++) {
        NSInteger x = target - array[i].integerValue;
        if ([dic objectForKey:@(x)]) {
            return @[@(i), ((NSNumber *)[dic objectForKey:@(x)])];
        }
        [dic setObject:@(i) forKey:array[i]];
    }
    return nil;
}
@end
