package week05

func minPathSum(grid [][]int) int {

	m := len(grid)
	n := len(grid[0])

	for x := 1; x < m; x++ {
		grid[x][0] += grid[x-1][0]
	}

	for y := 1; y < n; y++ {
		grid[0][y] += grid[0][y-1]
	}

	for x := 1; x < m; x++ {
		for y := 1; y < n; y++ {
			grid[x][y] = min(grid[x-1][y]+grid[x][y], grid[x][y-1]+grid[x][y])
		}
	}

	return grid[m-1][n-1]
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
