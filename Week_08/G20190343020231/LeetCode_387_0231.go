package main

func main() {

}

// 1. hashmap, 时间复杂度O(N),空间复杂度O(N)
func firstUniqChar(s string) int {
	map1 := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		map1[s[i]] = map1[s[i]] + 1
	}
	for i := 0; i < len(s); i++ {
		if val, ok := map1[s[i]]; ok && val == 1 {
			return i
		}
	}
	return -1
}

// 2. 优化：空间复杂度为O(1)
func firstUniqChar2(s string) int {
	arr := make([]int, 26)
	for i := 0; i < len(s); i++ {
		arr[s[i]-'a'] = arr[s[i]-'a'] + 1
	}
	for i := 0; i < len(s); i++ {
		if arr[s[i]-'a'] == 1 {
			return i
		}
	}
	return -1
}
