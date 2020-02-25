//
//  Oms.m
//  Algorithm
//
//  Created by liuk on 2020/2/23.
//  Copyright © 2020 glodon. All rights reserved.
//

#import "Oms.h"
#define MAX(a, b) ((a) > (b) ? (a) : (b))

@implementation Oms

int longestValidParentheses(char * s){
    int sLen = strlen(s);
    int *stack = (int *)calloc(1, sizeof(int) * (sLen + 2));
    int top = 0;
    int i, topIndex, ans;
    ans = 0;
    stack[top++] = -1;
    for (i = 0; i < sLen; i++) {
        if (s[i] == ')') {
            if (top != 1) {
                topIndex = stack[top - 1];
                if (s[topIndex] == '(') {
                    top--;
                    continue;
                }
            }
        }
        stack[top++] = i;
    }
    stack[top++] = i;
    for (i = 1; i < top; i++) {
        ans = MAX(ans, stack[i] - stack[i - 1] - 1);
    }
    free(stack);
    return ans;
}

@end
