package main

import (
	"fmt"
)

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	rec := make([]int, 26)
	sb := []byte(s)
	tb := []byte(t)

	for k := range sb {
		rec[sb[k]-'a']--
		rec[tb[k]-'a']++
	}

	for _, v := range rec {
		if v != 0 {
			return false
		}
	}

	return true
}

func isAnagram2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	// 兼容Unicode字符
	sr := []rune(s)
	tr := []rune(t)

	rec := make(map[rune]int, len(sr))
	for k := range sr {
		rec[sr[k]]++
		rec[tr[k]]--
	}

	for _, v := range rec {
		if v != 0 {
			return false
		}
	}

	return true
}

func main() {
	s := "anagram"
	t := "nagaram"
	res := isAnagram(s, t)
	fmt.Println(res)
}
