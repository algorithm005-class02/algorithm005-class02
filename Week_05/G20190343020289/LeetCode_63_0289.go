package G20190343020289

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	// temp
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		if obstacleGrid[i][0] != 1 {
			dp[i][0] = 1
		}
	}
	for i := 0; i < n; i++ {
		if obstacleGrid[0][i] != 1 {
			dp[0][i] = 1
		}
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[m-1][n-1]
}
