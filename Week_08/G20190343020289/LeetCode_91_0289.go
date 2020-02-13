package G20190343020289

//91. 解码方法
func numDecodings(s string) int {
	// dp
	n := len(s)
	dp := make([]int, n+1)
	dp[0] = 1
	if s[0] != '0' {
		dp[1] = 1
	} else {
		dp[1] = 0
	}

	for i := 2; i <= n; i++ {
		if s[i-1] != '0' {
			dp[i] += dp[i-1]
		}
		if isValidTwoDigit(s[i-2], s[i-1]) {
			dp[i] += dp[i-2]
		}
	}
	return dp[n]
}

func isValidTwoDigit(a, b byte) bool {
	return (a == '1' && b <= '9') || (a == '2' && b <= '6')
}
