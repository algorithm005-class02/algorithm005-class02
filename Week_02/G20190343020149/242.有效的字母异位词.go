package leetcode

/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	// 26个英文字母
	var cacheArr [26]int
	sLen := len(s)
	i := 0
	for {
		if i >= sLen {
			break
		}
		sIndex := s[i] - 97
		tIndex := t[i] - 97
		// 相同则抵消 不同则计数
		if sIndex != tIndex {
			cacheArr[sIndex]++
			cacheArr[tIndex]--
		}
		i++
	}
	for _, val := range cacheArr {
		if val != 0 {
			return false
		}
	}

	return true
}

// @lc code=end'
