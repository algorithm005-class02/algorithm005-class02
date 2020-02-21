package G20190343020289

//242. 有效的字母异位词
func isAnagram(s string, t string) bool {
	// 排序
	//return sortString(s)==sortString(t)

	// 哈希表
	// 实际复杂度O(n) 空间复杂度O(1)
	if len(s) != len(t) {
		return false
	}
	// 一共26个字母
	m := make([]int, 26)
	for i := 0; i < len(s); i++ {
		// a的ASCII码为97，其他字母减a得到对应的索引
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

//func sortString(w string) string{
//	s:=strings.Split(w,"")
//	sort.Strings(s)
//	return strings.Join(s,"")
//}
