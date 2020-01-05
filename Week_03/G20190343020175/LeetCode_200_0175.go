package main

func numIslands(grid [][]byte) int {
	islands := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				islands += sink(grid, i, j)
			}
		}
	}

	return islands
}

func sink(grid [][]byte, i, j int) int {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) || '0' == grid[i][j] {
		return 0
	}

	grid[i][j] = '0'
	sink(grid, i+1, j)
	sink(grid, i-1, j)
	sink(grid, i, j+1)
	sink(grid, i, j-1)
	return 1
}
