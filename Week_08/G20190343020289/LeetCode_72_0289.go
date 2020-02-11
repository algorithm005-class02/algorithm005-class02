package G20190343020289

//72. 编辑距离
func minDistance(word1 string, word2 string) int {
	// DP
	// 推导状态转换方程
	var (
		len1 = len(word1) + 1
		len2 = len(word2) + 1
		dp   = make([][]int, len1)
	)
	for i := 0; i < len1; i++ {
		dp[i] = make([]int, len2)
		dp[i][0] = i
	}
	for j := 0; j < len2; j++ {
		dp[0][j] = j
	}
	for i := 1; i < len1; i++ {
		for j := 1; j < len2; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = Min(dp[i-1][j], Min(dp[i-1][j-1], dp[i][j-1])) + 1
			}
		}
	}
	return dp[len1-1][len2-1]
}

func Min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
