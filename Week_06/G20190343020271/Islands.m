//
//  Islands.m
//  Algorithm
//
//  Created by liuk on 2020/2/23.
//  Copyright © 2020 glodon. All rights reserved.
//

#import "Islands.h"

@implementation Islands
int dfs(char** grid, int gridSize, int* gridColSize, int row, int col) {
    if (row < 0 || row > gridSize -1 || col < 0 || col > gridColSize[0] -1 || grid[row][col] != '1') {
        return 0;
    }
    

    grid[row][col] = 'A';

    dfs(grid, gridSize, gridColSize, row - 1, col);
    dfs(grid, gridSize, gridColSize, row + 1, col);
    dfs(grid, gridSize, gridColSize, row, col - 1);
    dfs(grid, gridSize, gridColSize, row, col + 1);

    return 1;
}

int numIslands(char** grid, int gridSize, int* gridColSize){
    int num = 0;
    int i, j;

    for (i = 0; i < gridSize; i++) {
        for (j = 0; j < gridColSize[0]; j++) {
            if (grid[i][j] == '1') {
                num += dfs(grid, gridSize, gridColSize, i, j);
            }
        }
    }
    return num;
}

@end
