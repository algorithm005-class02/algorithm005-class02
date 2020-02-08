package G20190343020231


// 1. 判断length之后，按字母序排序（Unicode参考https://www.cnblogs.com/huahuahu/p/Unicode-zi-fu-chuan-pai-xu-gui-ze-yi-ru-he-que-din.html），然后一遍for来遍历比较每个位置的单词是否一样，取决于排序的时间复杂度
// 3 使用固定长度的数组
// 2 使用哈希表，先判断length，维护两个map计数每个单词每个字符出现的次数，时间复杂度O(N)，空间复杂度O(N)

// 2.
// 3. 使用map，适用于unicode
type runeSlice []rune

func (rs runeSlice) Len() int {
	return len(rs)
}

func (rs runeSlice) Less(i, j int) bool {
	return rs[i] < rs[j]
}

func (rs runeSlice) Swap(i, j int) {
	temp := rs[i]
	rs[i] = rs[j]
	rs[j] = temp
}

// 1. 排序之后，一遍loop比较
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	var temp1, temp2 runeSlice
	temp1, temp2 = []rune(s), []rune(t)
	sort.Sort(temp1)
	sort.Sort(temp2)
	for i := 0; i < len(temp1); i++ {
		if temp1[i] != temp2[i] {
			return false
		}
	}
	return true
}