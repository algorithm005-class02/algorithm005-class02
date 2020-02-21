package week08

func firstUniqChar(s string) int {
	hash := make([]int, 26)
	for _, j := range s {
		hash[j-'a']++
	}
	for i, j := range s {
		if hash[j-'a'] == 1 {
			return i
		}
	}
	return -1
}
