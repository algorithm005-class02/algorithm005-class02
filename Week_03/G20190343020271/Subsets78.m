//
//  Subsets78.m
//  Algorithm
//
//  Created by liuk on 2019/12/25.
//  Copyright © 2019 glodon. All rights reserved.
//

#import "Subsets78.h"

@implementation Subsets78
- (NSMutableArray <NSArray<NSNumber *>*> *)subsets:(NSArray <NSNumber *>*)nums{
    NSMutableArray <NSArray<NSNumber *>*> *array = [@[] mutableCopy];
    [self dfs:array nums:nums list:[@[] mutableCopy] index:0];
    return array;
}

- (void)dfs:(NSMutableArray <NSArray<NSNumber *>*> *)ans nums:(NSArray<NSNumber *>*)nums  list:(NSMutableArray<NSNumber *>*)list index:(int)index{
    [ans addObject:[list copy]];
    for (NSInteger j = 0; j < nums.count; j++) {
        [list addObject:nums[j]];
        [self dfs: ans nums:nums list:list index:j + 1];
        [list removeObjectAtIndex:list.count - 1];
    }
}
@end
