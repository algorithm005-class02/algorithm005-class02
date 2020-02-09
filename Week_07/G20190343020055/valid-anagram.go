package week07

func isAnagram(s string, t string) bool {

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
