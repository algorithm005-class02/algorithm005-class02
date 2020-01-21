func longestValidParentheses(s string) int {
	length := len(s)
	maxLen := 0
	dp := make([]int, length)
	for i := 1; i < length; i++ {
		if s[i] == ')' {
			if s[i-1] == '(' {
				if i > 1 {
					dp[i] = dp[i-2] + 2
				} else {
					dp[i] = 2
				}
			} else if i-dp[i-1] > 0 && s[i-dp[i-1]-1] == '(' {
				if (i - dp[i-1]) >= 2 {
					dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
				} else {
					dp[i] = dp[i-1] + 2
				}
			}
			if maxLen < dp[i] {
				maxLen = dp[i]
			}
		}
	}
	return maxLen
}