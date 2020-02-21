
func groupAnagrams(strs []string) [][]string {

	allArr := make([][]string, 0, 0)
	for len(strs) > 0 {

		s1, sliceArr := strs[0], make([]string, 0, 0)

		sliceArr = append(sliceArr, s1)
		strs = append(strs[:0], strs[1:]...)

		for index := 0; index < len(strs); index++ {

			if isTheAnagram(s1, strs[index]) {

				sliceArr = append(sliceArr, strs[index])
				strs = append(strs[:index], strs[index+1:]...)
				index--
			}
		}
		allArr = append(allArr, sliceArr)
	}
	return allArr
}

func isTheAnagram(s string, t string) bool {

	isA, m := true, make(map[string]int)

	for _, ch := range s {

		if v, ok := m[string(ch)]; ok {
			m[string(ch)] = v + 1
		} else {
			m[string(ch)] = 1
		}
	}

	for _, ch := range t {
		if v, ok := m[string(ch)]; ok {
			v--
			if v <= 0 {
				delete(m, string(ch))
			} else {
				m[string(ch)] = v
			}
		} else {
			isA = false
			break
		}
	}

	if isA {
		if len(m) > 0 {
			isA = false
		}
	}
	return isA
}
