//
//  FriendCycle.m
//  Algorithm
//
//  Created by liuk on 2020/2/23.
//  Copyright © 2020 glodon. All rights reserved.
//

#import "FriendCycle.h"

@implementation FriendCycle
int N[200];

void setN(int target, int replace, int size)
{
    int i;
    for (i = 0; i < size; i++)
    {
        if (N[i] == target)
        {
            N[i] = replace;
        }
    }
}

int findCircleNum(int** M, int MSize, int* MColSize){
    int i, j, count, mark;
    
    if (MSize == 0)
    {
        return 0;
    }
    
    for (i = 0; i < 200; i++)
    {
        N[i] = i;
    }
    
    for (i = 0; i < MSize; i++)
    {
        for (j = i; j < MSize; j++)
        {
            if (M[i][j] == 1)
            {
                if (N[j] < N[i])
                {
                    setN(N[i], N[j], MSize);
                }
                else
                {
                    N[j] = N[i];
                }
            }
        }
    }
    
    for (i = MSize - 1; i >= 0; i--)
    {
        for ( j = i; j >= 0; j --)
        {
            if (M[i][j] == 1)
            {
                if (N[i] < N[j])
                {
                    setN(N[j], N[i], MSize);
                }
            }
        }
    }
    
    count = 1;
    mark = 0;
    for (i = 0; i < MSize; i ++)
    {
        if (N[i] > mark)
        {
            count++;
            mark = N[i];
        }
    }
    
    *MColSize = count;
    return count;
}

@end
