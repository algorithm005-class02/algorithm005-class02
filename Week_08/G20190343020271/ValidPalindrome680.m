//
//  ValidPalindrome680.m
//  Algorithm
//
//  Created by liuk on 2020/2/16.
//  Copyright © 2020 glodon. All rights reserved.
//

#import "ValidPalindrome680.h"

@implementation ValidPalindrome680
bool validPalindrome(char * s){
    for (int i = 0, j = strlen(s)-1; i < j; ++i, --j)
        if (s[i] != s[j])
            return (judge(s, i+1,j) || judge(s, i,j-1));
    return true;
}
int judge(char *str, int i, int j) {
    while (i < j) if (str[i++] != str[j--]) return false;
    return true;
}
@end
