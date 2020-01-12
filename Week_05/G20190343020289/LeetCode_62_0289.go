package G20190343020289

func uniquePaths(m int, n int) int {
	// 动态规划
	//dp := make([][]int, m)
	//for i := 0; i < m; i++ {
	//	dp[i] = make([]int, n)
	//	dp[i][0] = 1
	//}
	//for i := 0; i < n; i++ {
	//	dp[0][i] = 1
	//}
	//for i := 1; i < m; i++ {
	//	for j := 1; j < n; j++ {
	//		dp[i][j] = dp[i-1][j] + dp[i][j-1]
	//	}
	//}
	//return dp[m-1][n-1]

	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if i == 0 || j == 0 {
				dp[i][j] = 1
			} else {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}
	return dp[m-1][n-1]
}
