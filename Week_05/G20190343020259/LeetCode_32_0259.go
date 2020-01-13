package G20190343020259

func longestValidParentheses(s string) int {
	if len(s) < 2 {
		return 0
	}

	var max = 0
	var dp = make([]int, len(s))

	for i := 1; i < len(s); i++ {
		if s[i] == ')' {
			if s[i-1] == '(' {
				pre := 0
				if i >= 2 {
					pre = dp[i-2]
				}
				dp[i] = pre + 2
			} else if (i - dp[i-1] > 0) && (s[i-dp[i-1]-1] == '(') {
				pre := 0
				if i - dp[i-1] - 2 > 0 {
					pre = dp[i - dp[i-1] -2]
				}
				dp[i] = dp[i-1] + pre + 2
			}
			if dp[i] > max {
				max = dp[i]
			}
		}
	}

	return max
}
