func minPathSum(grid [][]int) int {
	y, x := len(grid), len(grid[0])
	dp := make([][]int, y)
	for i := 0; i < y; i++ {
		dp[i] = make([]int, x)
	}

	for i := 0; i < y; i++ {
		for j := 0; j < x; j++ {
			if i < 1 && j < 1 {
				dp[i][j] = grid[i][j]
			} else if i < 1 {
				dp[i][j] = dp[i][j-1] + grid[i][j]
			} else if j < 1 {
				dp[i][j] = dp[i - 1][j] + grid[i][j]
			} else {
				dp[i][j] = min(dp[i-1][j], dp[i][j-1]) +  grid[i][j]
			}
		}
	}

	return dp[y-1][x-1]
}