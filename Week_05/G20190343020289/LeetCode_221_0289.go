package G20190343020289

//221. 最大正方形
func maximalSquare(matrix [][]byte) int {
	// dp(i,j)=min(dp(i-1,j),dp(i,j-1),dp(i-1,j-1))+1
	m := len(matrix)
	if m <= 0 {
		return 0
	}
	n := len(matrix[0])
	dp := make([][]int, m)
	maxLen := 0
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if matrix[i][j] == '1' {
				if i == 0 || j == 0 {
					dp[i][j] = 1
				} else {
					dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
				}
			} else {
				dp[i][j] = 0
			}
			maxLen = max(maxLen, dp[i][j])
		}
	}
	return maxLen * maxLen
}
