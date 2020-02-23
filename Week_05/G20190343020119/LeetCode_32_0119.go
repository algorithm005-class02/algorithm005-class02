func longestValidParentheses(s string) int {
	sLen := len(s)
	dp := make([]int, sLen, sLen)
	maxLen := 0
	for i := 1; i < sLen; i++ {
		if string(s[i]) == ")" {
			if string(s[i-1]) == "(" {
				prevLen := 0
				if i > 2 {
					prevLen = dp[i-2]
				}
				dp[i] = prevLen + 2
			} else if string(s[i-1]) == ")" {
				prevNum := dp[i-1]
				if i > prevNum && string(s[i-prevNum-1]) == "(" {
					addLen := 0
					if i-dp[i-1] >= 2 {
						addLen = dp[i-dp[i-1]-2]
					}
					dp[i] = dp[i-1] + addLen + 2
				}
			}
		}
		if dp[i] > maxLen {
			maxLen = dp[i]
		}
	}
	return maxLen
}

