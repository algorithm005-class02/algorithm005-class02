package main

import "strconv"

func numDecodings(s string) int {
	if len(s) == 0 || '0' == s[0] {
		return 0
	}

	dp := make([]int, len(s)+1)
	dp[0], dp[1] = 1, 1
	if s[0] == 0 {
		dp[1] = 0
	}

	for i := 2; i <= len(s); i++ {
		f, _ := strconv.Atoi(s[i-1 : i])
		s, _ := strconv.Atoi(s[i-2 : i])
		if 1 <= f && f <= 9 {
			dp[i] += dp[i-1]
		}
		if 10 <= s && s <= 26 {
			dp[i] += dp[i-2]
		}
	}

	return dp[len(s)]
}
