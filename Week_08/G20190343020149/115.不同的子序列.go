package leetcode

/*
 * @lc app=leetcode.cn id=115 lang=golang
 *
 * [115] 不同的子序列
 */

// @lc code=start
func numDistinct(s string, t string) int {
	m := len(s)
	n := len(t)
	if n > m {
		return 0
	}
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, m+1)
		if i == 0 {
			for j := range dp[0] {
				dp[0][j] = 1
			}
		}
	}
	for i := 1; i < n+1; i++ {
		for j := i; j < m+1; j++ {
			if s[j-1] == t[i-1] {
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
			} else {
				dp[i][j] = dp[i][j-1]
			}
		}
	}
	return dp[n][m]
}

// @lc code=end
