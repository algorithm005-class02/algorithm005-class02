package leetcode

func longestValidParentheses(s string) int {
	if len(s) < 2 {
		return 0
	}
	dp := make([]int, len(s))
	maxLen := 0
	for i := 1; i < len(s); i++ {
		if s[i] == ')' {
			if s[i-1] == '(' {
				if i >= 2 {
					dp[i] = dp[i-2] + 2
				} else {
					dp[i] = 2
				}
			} else {
				preI := i - 1 - dp[i-1]
				if preI >= 0 && s[preI] == '(' {
					preV := 0
					if preI >= 1 {
						preV = dp[preI-1]
					}
					dp[i] = preV + dp[i-1] + 2
				}
			}
			if dp[i] > maxLen {
				maxLen = dp[i]
			}
		}
	}
	return maxLen
}
