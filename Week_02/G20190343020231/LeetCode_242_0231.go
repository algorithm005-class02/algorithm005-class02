package main

import (
	"fmt"
	"sort"
)

func main()  {
	t1, s1 := "nact", "cant"
	t2, s2 := "anagram", "nagarbm"
	fmt.Println(isAnagram1(t1, s1))
	fmt.Println(isAnagram1(t2, s2))
	fmt.Println(isAnagram3(t1, s1))
	fmt.Println(isAnagram3(t2, s2))
}

type runeSlice []rune

func (rs runeSlice) Len() int {
	return len(rs)
}

func (rs runeSlice) Less(i, j int) bool {
	return rs[i] < rs[j]
}

func (rs runeSlice) Swap(i, j int) {
	temp := rs[i]
	rs[i] = rs[j]
	rs[j] = temp
}

// 1. 排序之后，一遍loop比较。取决于不同语言的sort的实现
func isAnagram1(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	var temp1, temp2 runeSlice
	temp1, temp2 = []rune(s), []rune(t)
	sort.Sort(temp1)
	sort.Sort(temp2)
	for i := 0; i < len(temp1); i++ {
		if temp1[i] != temp2[i] {
			return false
		}
	}
	return true
}

// 2. 使用固定长度的数组，时间复杂度O(N)，空间复杂度O(1)
func isAnagram2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	table := [26]int{}
	for i := 0; i < len(s); i++ {
		table[s[i] - 'a'] = table[s[i] - 'a'] + 1
		table[t[i] - 'a'] = table[t[i] - 'a'] - 1
	}
	for _, val := range table {
		if val != 0 {
			return false
		}
	}
	return true
}

// 3. 使用map，适用于unicode。时间复杂度O(N)，空间复杂度O(N)，测试显示速度较慢
// 执行用时 :16 ms, 在所有 golang 提交中击败了18.60%的用户
// 内存消耗 :3 MB, 在所有 golang 提交中击败了75.97%的用户
func isAnagram3(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	tempMap := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		if _, ok := tempMap[s[i]]; !ok {
			tempMap[s[i]] = 1
		} else {
			tempMap[s[i]]++
		}
		if _, ok := tempMap[t[i]]; !ok {
			tempMap[t[i]] = -1
		} else {
			tempMap[t[i]]--
		}
	}
	for _, val := range tempMap {
		if val != 0 {
			return false
		}
	}
	return true
}
