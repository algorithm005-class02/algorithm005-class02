//
//  FirstUniqChar387.h
//  Algorithm
//
//  Created by liuk on 2020/2/16.
//  Copyright © 2020 glodon. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface FirstUniqChar387 : NSObject
int firstUniqChar(char * s){
    int i, len = strlen(s);
    int p[26];
    memset(p, 0, sizeof(int) * 26);
   
    for(i = 0; i < len; i++){
        p[s[i] - 'a']++;
    }
    for(i = 0; i < len; i++){
        if(p[s[i] - 'a'] == 1)
            return i;
    }
    return -1;
}
@end

NS_ASSUME_NONNULL_END
