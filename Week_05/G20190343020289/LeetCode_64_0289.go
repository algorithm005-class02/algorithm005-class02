package G20190343020289

//64. 最小路径和
func minPathSum(grid [][]int) int {
	// 动态递推
	//dp(i,j)=grid[i][j]+Min(grid(i+1,j),grid(i,j+1)
	m := len(grid)
	n := len(grid[0])
	dp := grid
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			if i == m-1 && j == n-1 {
			} else if i == m-1 {
				dp[i][j] += dp[i][j+1]
			} else if j == n-1 {
				dp[i][j] += dp[i+1][j]
			} else {
				dp[i][j] += min(dp[i][j+1], dp[i+1][j])
			}
		}
	}
	return dp[0][0]
}

func min(a ...int) int {
	m := int(^uint(0) >> 1)
	for _, i := range a {
		if i < m {
			m = i
		}
	}
	return m
}

func max(a ...int) int {
	m := int(^int(^uint(0) >> 1))
	for _, i := range a {
		if i > m {
			m = i
		}
	}
	return m
}
