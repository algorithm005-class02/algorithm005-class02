package main

import (
	"bytes"
	"sort"
)

func isAnagramSorting(s string, t string) bool {
	sBytes := []byte(s)
	tBytes := []byte(t)

	sort.Slice(sBytes, func(i, j int) bool { return sBytes[i] < sBytes[j] })
	sort.Slice(tBytes, func(i, j int) bool { return tBytes[i] < tBytes[j] })

	return 0 == bytes.Compare(sBytes, tBytes)
}

func isAnagramHash(s string, t string) bool {
	counts := make([]int, 256)

	for i := 0; i < len(s); i++ {
		counts[s[i]]++
	}
	for j := 0; j < len(t); j++ {
		counts[t[j]]--
	}
	for _, c := range counts {
		if 0 != c {
			return false
		}
	}

	return true
}

/*
func main() {
	fmt.Println(isAnagramSorting("anagram", "nagaram"))
	fmt.Println(isAnagramSorting("rat", "car"))
	fmt.Println(isAnagramSorting("a", "ab"))
	fmt.Println(isAnagramSorting("ab", "a"))

	fmt.Println(isAnagramHash("anagram", "nagaram"))
	fmt.Println(isAnagramHash("rat", "car"))
	fmt.Println(isAnagramHash("a", "ab"))
	fmt.Println(isAnagramHash("ab", "a"))
}
*/
