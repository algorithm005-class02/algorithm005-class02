import "fmt"

func isAnagram(s, t string) bool {

	isA, m := true, make(map[string]int)

	for _, ch := range s {

		if v, ok := m[string(ch)]; ok {
			m[string(ch)] = v + 1
		} else {
			m[string(ch)] = 1
		}
	}
	fmt.Println("map有值: ", m)

	for _, ch := range t {
		if v, ok := m[string(ch)]; ok {

			fmt.Println("key: ", string(ch))
			v--
			if v <= 0 {
				fmt.Println("删除key：", string(ch))
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
