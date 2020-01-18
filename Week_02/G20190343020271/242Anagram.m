//
//  242Anagram.m
//  Algorithm
//
//  Created by liuk on 2019/12/22.
//  Copyright © 2019 glodon. All rights reserved.
//

#import "242Anagram.h"

@implementation _42Anagram
bool isValidAnagram(char *s, char *t){
    if (strlen(s) != strlen(t)) {
        return false;
    }
    int a[26] = {0};
    for (int i = 0; i < strlen(s); i++) {
        a[s[i] - 'a'] ++;
        a[t[i] - 'a'] --;
    }
    for (int i = 0; i < 26; i++) {
        if (a[i] != 0) {
            return false;
        }
    }
    return true;
}
@end
