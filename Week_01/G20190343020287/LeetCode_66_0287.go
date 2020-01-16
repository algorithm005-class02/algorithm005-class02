package leetcode

// 题目地址 https://leetcode-cn.com/problems/plus-one/
// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。
// 示例:输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。输入: [9,9] 输出: [1,0,0] 解释: 输入数组表示数字 123。
/*
 * @lc app=leetcode.cn id=66 lang=golang
 *
 * [66] 加一
 */

// @lc code=start
// plusOne 判断有没有进位，循环直到判断没有再进位就退出循环返回结果。
func plusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		digits[i] += 1
		if digits[i] == 10 {
			digits[i] %= 10
		} else {
			return digits
		}
	}
	return append([]int{1}, digits...)
}

// @lc code=end
