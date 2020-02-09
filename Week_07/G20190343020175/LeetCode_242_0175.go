package main

func isAnagram(s string, t string) bool {
	byteCount := make([]int, 256)

	for i := 0; i < len(s); i++ {
		byteCount[s[i]]++
	}
	for i := 0; i < len(t); i++ {
		byteCount[t[i]]--
	}
	for i := 0; i < 256; i++ {
		if 0 != byteCount[i] {
			return false
		}
	}
	return true
}
