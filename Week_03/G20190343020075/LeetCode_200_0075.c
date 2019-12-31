
int direction[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1}  };

void sink_island(char** grid,int row,int col,int crow,int ccol) {
    if (crow < 0 || crow == row || ccol < 0 || ccol == col || grid[crow][ccol] == '0') {
        return;
    }
    grid[crow][ccol] = '0';
//    上下左右
    for (int dir = 0; dir < 4; ++dir) {
        int nrow = crow+direction[dir][0];
        int ncol = ccol+direction[dir][1];
        sink_island(grid,row,col,nrow,ncol);
    }
}

int numIslands(char** grid, int gridSize, int* gridColSize){
    int count = 0 ;

    if (gridSize == 0) {
        return 0;
    }

    for (int row = 0; row < gridSize; ++row) {
        for (int col = 0; col < gridColSize[0]; ++col) {
            if (grid[row][col] == '1') {
                sink_island(grid,gridSize,gridColSize[0],row,col);
                count ++;
            }
        }
    }

    return count;
}


