package main

func firstUniqChar(s string) int {
	count := make([]int, 26)
	for i := 0; i < len(s); i++ {
		count[int(s[i]-'a')]++
	}
	for i := 0; i < len(s); i++ {
		if count[int(s[i]-'a')] == 1 {
			return i
		}
	}
	return -1
}
