package G20190343020171

/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
func isAnagram(s string, t string) bool {
	source := []byte(s)
	target := []byte(t)
	if len(source) != len(target) {
		return false
	}
	// 1. 暴力解法，sort, 时间复杂度 O(nlogn) + O(n) runs 12ms
	/***
	flag := true
	sort.Slice(source, func(i int, j int) bool { return source[i] < source[j] })
	sort.Slice(target, func(i int, j int) bool { return target[i] < target[j] })
	fmt.Printf("source=%s, target=%s\n", source, target)
	for idx := range source {
		if source[idx] != target[idx] {
			flag = false
		}
	}
	return flag
	***/
	// hash table --> 统计频次 runs <1ms
	var table [26]int
	for idx := range source {
		table[source[idx]-byte('a')]++
		table[target[idx]-byte('a')]--
	}
	for i := range table {
		if table[i] != 0 {
			return false
		}
	}
	return true
}

// @lc code=end
