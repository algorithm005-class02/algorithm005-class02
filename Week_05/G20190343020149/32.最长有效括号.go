package leetcode

/*
 * @lc app=leetcode.cn id=32 lang=golang
 *
 * [32] 最长有效括号
 */

// @lc code=start
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

// 1. 子问题:
// 只记录到元素为")"的位置的有效括号长度
// 如果s[i] 为 ")" 且s[i-1] 为 "("
// i位置的有效括号长度为到i-2位置的有效括号长度加2
// 如果s[i] 为 ")" 且s[i-1] 为 ")"
// 那么需要找到s[i] 对应的"("
// 即判断在s[i-1]位置的有效子括号长度前一个位置是否为"("
// 如果找到该位置的有效括号长度即为 前一个位置的的有效括号长度加2
// 2. 存储中间状态
// 一个一维数组记录到对应位置的有效括号长度 dp
// 3. DP方程
// if s[i] == ")" && s[i-1] == "(" {
// 	dp[i] = dp[i-2] + 2
// } else if s[i] == ")" && s[i-1] == ")" {
//	if s[i - 1 - dp[i-1]] == "(" {
// 		s[i] = dp[i-1] + dp[(i - 2 - dp[i-1])] + 2
// }
// }
//
// @lc code=end
