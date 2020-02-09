//
//  PowerOf2231.h
//  Algorithm
//
//  Created by liuk on 2020/2/9.
//  Copyright © 2020 glodon. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface PowerOf2231 : NSObject
bool isPowerOfTwo(int n) {
  if (n == 0) return false;
  long x = n;
  return (x & (x - 1)) == 0;
}
@end

NS_ASSUME_NONNULL_END
