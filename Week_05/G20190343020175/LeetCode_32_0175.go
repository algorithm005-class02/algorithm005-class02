package main

func longestValidParentheses(s string) int {
	dp := make([]int, len(s))
	max := 0
	for i := 1; i < len(s); i++ {
		if ')' == s[i] {
			if s[i-1] == '(' {
				dp[i] = 2
				if i >= 2 {
					dp[i] += dp[i-2]
				}
			} else if i-dp[i-1] > 0 && s[i-dp[i-1]-1] == '(' {
				dp[i] = dp[i-1] + 2
				if i-dp[i-1] >= 2 {
					dp[i] += dp[i-dp[i-1]-2]
				}
			}
			max = maxInt(max, dp[i])
		}

	}
	return max
}
