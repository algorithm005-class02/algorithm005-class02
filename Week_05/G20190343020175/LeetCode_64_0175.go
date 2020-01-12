package main

func minPathSum(grid [][]int) int {
	dp := make([][]int, len(grid))
	for i := range grid {
		dp[i] = make([]int, len(grid[i]))
		copy(dp[i], grid[i])
	}

	colCount, rowCount := len(dp[0]), len(dp)
	for i := 0; i < rowCount; i++ {
		for j := 0; j < colCount; j++ {
			if i == 0 && j != 0 {
				dp[i][j] += dp[i][j-1]
			} else if i != 0 && j == 0 {
				dp[i][j] += dp[i-1][j]
			} else if i != 0 && j != 0 {
				dp[i][j] += minInt(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[rowCount-1][colCount-1]
}
