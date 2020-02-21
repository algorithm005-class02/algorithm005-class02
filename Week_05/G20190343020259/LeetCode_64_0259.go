package G20190343020259

func minPathSum(grid [][]int) int {
	if len(grid) < 1 {
		return 0
	}

	m := len(grid)
	n := len(grid[0])

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 && j == 0 {
				grid[i][j] = grid[i][j]
			} else if i == 0 && j != 0 {
				grid[i][j] = grid[i][j] + grid[i][j-1]
			} else if i != 0 && j == 0 {
				grid[i][j] = grid[i][j] + grid[i-1][j]
			} else {
				min := grid[i][j-1]
				if grid[i][j-1] > grid[i-1][j] {
					min = grid[i-1][j]
				}
				grid[i][j] = min + grid[i][j]
			}
		}
	}

	return grid[m-1][n-1]
}
