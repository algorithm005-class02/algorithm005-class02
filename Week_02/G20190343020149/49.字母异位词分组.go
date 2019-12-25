package leetcode

import (
	"strings"
)

/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 */

// @lc code=start
func groupAnagrams(strs []string) [][]string {

	result := [][]string{}
	resultMap := map[string][]string{}
	// 遍历分组链表
	for _, str := range strs {
		sortedStr := sortStr(str)
		resultMap[sortedStr] = append(resultMap[sortedStr], str)
	}

	for _, val := range resultMap {
		result = append(result, val)
	}
	return result
}

// O(n)字母排序
func sortStr(s string) string {
	strArr := [26]int{}
	result := ""
	for _, val := range s {
		charIndex := val - 97
		strArr[charIndex]++
	}
	for i, charNum := range strArr {
		if charNum > 0 {
			charCode := i + 97
			curStr := string(charCode)
			if charNum > 1 {
				curStr = strings.Repeat(curStr, charNum)
			}
			result += curStr
		}
	}
	return result
}

// @lc code=end

// GroupAnagrams start test 94 groupAnagrams
func GroupAnagrams() {
	case1 := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	groupAnagrams(case1)
}
