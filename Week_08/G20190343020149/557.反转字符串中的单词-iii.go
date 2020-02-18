package leetcode

import (
	"strconv"
	"strings"
)

/*
 * @lc app=leetcode.cn id=557 lang=golang
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
func reverseWords(s string) string {
	sArr := strings.Split(s, " ")
	for i, w := range sArr {
		sArr[i] = reverseWord(w)
	}
	strconv.Atoi(s)
	return strings.Join(sArr, " ")
}

func reverseWord(s string) string {
	l := len(s)
	sArr := make([]rune, l)
	for i, c := range s {
		sArr[l-1-i] = c
	}
	return string(sArr)
}

// @lc code=end
