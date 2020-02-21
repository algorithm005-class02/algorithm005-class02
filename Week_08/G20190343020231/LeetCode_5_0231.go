package main

import "fmt"

func main() {
	fmt.Println(longestPalindrome("babad"))
	fmt.Println(longestPalindrome("cbbd"))
	fmt.Println(longestPalindrome("cd"))
	fmt.Println(longestPalindrome("d"))
	fmt.Println(longestPalindrome("def"))
	fmt.Println(longestPalindrome("deed"))
	fmt.Println(longestPalindrome("defed"))
	fmt.Println(longestPalindrome(""))
	fmt.Println(longestPalindrome("abcdefgh"))

	fmt.Println()
	fmt.Println(longestPalindrome2("babad"))
	fmt.Println(longestPalindrome2("cbbd"))
	fmt.Println(longestPalindrome2("cd"))
	fmt.Println(longestPalindrome2("d"))
	fmt.Println(longestPalindrome2("def"))
	fmt.Println(longestPalindrome2("deed"))
	fmt.Println(longestPalindrome2("defed"))
	fmt.Println(longestPalindrome2(""))
	fmt.Println(longestPalindrome2("abcdefgh"))
	fmt.Println()
	fmt.Println(longestPalindrome3("babad"))
	fmt.Println(longestPalindrome3("cbbd"))
	fmt.Println(longestPalindrome3("cd"))
	fmt.Println(longestPalindrome3("d"))
	fmt.Println(longestPalindrome3("def"))
	fmt.Println(longestPalindrome3("deed"))
	fmt.Println(longestPalindrome3("defed"))
	fmt.Println(longestPalindrome3(""))
	fmt.Println(longestPalindrome3("abcdefgh"))
}

// 1. 暴力穷举，时间复杂度O(n^3)
// 2. 动态规划，dp[i][j]表示从i到j的最长回文子串
// if s[i] s[j]
// dp [i][j] =
// dp[i][j] = dp[i-1][j-1] + 2 (s[i] == [j])
//	b a b a b[i]
//b   1 0 0 0 0
//a   1 1 0 0 0
//b   3 1 1 0 0
//a   3 3 1 1 0
//b   5 3 3 1 1

// 定义dp[i][j]是否是回文，用left，right记录最大的回文范围
// i<=j
func longestPalindrome(s string) string {
	n := len(s)
	if n == 0 {
		return ""
	}
	dp := make([][]bool, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]bool, n)
		//dp[i][i] = true // j-i做了短路，不用初始化对角线
	}
	left, right := 0, 0 // 至少有一个字符，也是回文
	for i := n - 2; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			dp[i][j] = (s[i] == s[j]) && (j-i < 3 || dp[i+1][j-1]) // j-i<3做了一个短路，ada 一定是
			if dp[i][j] && j-i > right-left {
				left, right = i, j
			}
		}
	}
	return s[left : right+1]
}

func longestPalindrome2(s string) string {
	maxStr := ""
	n := len(s)
	subStr := ""
	for i := 0; i < n; i++ {
		// 以1个为中心 bab
		subStr = helper(s, i, i)
		if len(subStr) > len(maxStr) {
			maxStr = subStr
		}
		// 以2个为中心 baab
		subStr = helper(s, i, i+1)
		if len(subStr) > len(maxStr) {
			maxStr = subStr
		}
	}
	return maxStr
}

func helper(s string, i, j int) string {
	n := len(s)
	for i >= 0 && j < n && s[i] == s[j] {
		i--
		j++
	}
	return s[i+1 : j]
}

// babad
// b开始
func longestPalindrome3(s string) string {
	n := len(s)
	if n == 0 {
		return ""
	}
	tempLen1, tempLen2 := 0, 0
	start, end, len := 0, 0, 0
	for i := 0; i < n; i++ {
		// 以1个为中心 bab
		tempLen1 = helper2(s, i, i)
		// 以2个为中心 baab
		tempLen2 = helper2(s, i, i+1)
		len = max(tempLen2, tempLen1)
		if len > end-start {
			// 计算起始和终止
			start = i - (len-1)/2
			end = i + len/2
		}
	}
	return s[start : end+1]
}

// 以i，j为中心，找回文
func helper2(s string, i, j int) int {
	n := len(s)
	left, right := i, j
	for left >= 0 && right < n && s[left] == s[right] {
		left--
		right++
	}
	// 长度
	return right - left - 1
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
