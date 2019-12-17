package leetcode

// 题目地址 https://leetcode-cn.com/problems/valid-parenthese
// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串。
// 示例: 输入: "()" 输出: true 输入: "()[]{}" 输出: true 输入: "(]"  输出: false 输入: "([)]" 输出: false 输入: "{[]}" 输出: true

/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
 */

// @lc code=start
func isValid(s string) bool {
	stack := make([]rune, 0)
	parentheses := map[rune]rune{')': '(', ']': '[', '}': '{'}
	for _, char := range s {
		if char == '{' || char == '(' || char == '[' {
			stack = append(stack, char)
		} else if len(stack) > 0 && parentheses[char] == stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		} else {
			return false
		}
	}
	return len(stack) == 0
}

// @lc code=end
