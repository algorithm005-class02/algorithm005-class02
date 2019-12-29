package leetcode

// 题目地址 https://leetcode-cn.com/problems/valid-anagram/
// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
// 示例:输入: s = "anagram", t = "nagaram" 输出: true 输入: s = "rat", t = "car" 输出: false
// 说明: 你可以假设字符串只包含小写字母。

import "reflect"

/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
// isAnagram 循环两个字符串，将每个字符出现的次数记录到 map 中
// 比较两个 map 是否相等
func isAnagram(s string, t string) bool {
	ms, mt := make(map[rune]int, 0), make(map[rune]int, 0)
	for _, char := range s {
		ms[char] = ms[char] + 1
	}
	for _, char := range t {
		mt[char] = mt[char] + 1
	}
	return reflect.DeepEqual(ms, mt)
}

// @lc code=end
