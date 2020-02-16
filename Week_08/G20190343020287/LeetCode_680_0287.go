package leetcode

/*
 * @lc app=leetcode.cn id=680 lang=golang
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (34.12%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    12.9K
 * Total Submissions: 36.7K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 *
 * 输入: "aba"
 * 输出: True
 *
 *
 * 示例 2:
 *
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 *
 * 注意:
 *
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 *
 */

// @lc code=start
func validPalindrome(s string) bool {
	return doValidPalindrome(s, 0, len(s)-1, 0)
}

func doValidPalindrome(s string, l, r int, k int) bool {
	for l < r {
		if s[l] == s[r] {
			l++
			r--
		} else if k == 0 {
			return doValidPalindrome(s, l+1, r, k+1) || doValidPalindrome(s, l, r-1, k+1)
		} else {
			return false
		}
	}
	return true
}

// @lc code=end
