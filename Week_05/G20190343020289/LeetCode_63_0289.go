package G20190343020289

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	// 动态递推
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])
	if obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 {
		return 0
	}
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if i == 0 && j == 0 {
				// finish位置
				dp[i][j] = 1
			} else if i == 0 {
				// i为0的边界
				if obstacleGrid[i][j] == 1 || dp[i][j-1] == 0 {
					dp[i][j] = 0
				} else {
					dp[i][j] = 1
				}
			} else if j == 0 {
				// j为0的边界
				if obstacleGrid[i][j] == 1 || dp[i-1][j] == 0 {
					dp[i][j] = 0
				} else {
					dp[i][j] = 1
				}
			} else {
				// 非边界
				if obstacleGrid[i][j] == 1 || (dp[i-1][j] == 0 && dp[i][j-1] == 0) {
					dp[i][j] = 0
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1]
				}
			}
		}
	}
	return dp[m-1][n-1]
}
