package G20190343020289

//242. 有效的字母异位词
func isAnagram(s string, t string) bool {
	m := make([]int, 26)
	for i := 0; i < len(s); i++ {
		m[s[i]-'a']++
		m[t[i]-'a']--
	}
	for _, v := range m {
		if v != 0 {
			return false
		}
	}
	return true
}
