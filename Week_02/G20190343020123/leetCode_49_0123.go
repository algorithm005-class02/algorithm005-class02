package main

import "fmt"

//49. 字母异位词分组
//https://leetcode-cn.com/problems/group-anagrams
//思路：map 作为key->arry[]作为存储对应的异位分组，其中key为[26]int
//时间复杂度：
func groupAnagrams(str []string) [][]string {
	m := make(map[[26]int][]string)
	for _, v := range str {
		k := strArray(v)
		//map中的key [26]int不存在时
		s, ok := m[k]
		if !ok {
			s = make([]string, 0)
		}
		s = append(s, v)
		m[k] = s
	}
	res := make([][]string, 0, len(m))
	for _, v := range m {
		res = append(res, v)
	}
	return res
}
func strArray(s string) [26]int {
	res := [26]int{}
	for _, v := range s {
		res[v-'a']++
	}
	return res
}

func main() {
	s := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	res := groupAnagrams(s)
	fmt.Printf("res: %v\n", res)
}
