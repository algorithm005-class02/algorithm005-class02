package G20190343020289

//387. 字符串中的第一个唯一字符
func firstUniqChar(s string) int {
	m := make(map[rune]int, 0)
	for _, v := range s {
		m[v]++
	}
	for i, v := range s {
		if m[v] == 1 {
			return i
		}
	}
	return -1
}
