package main

import (
	"fmt"
	"sort"
)

func groupAnagrams(strs []string) [][]string {
	ret := [][]string{}
	posMap := make(map[string]int)

	for _, str := range strs {
		strBytes := []byte(str)
		sort.Slice(strBytes, func(i, j int) bool { return strBytes[i] < strBytes[j] })
		strSorted := string(strBytes)

		if pos, ok := posMap[strSorted]; ok {
			ret[pos] = append(ret[pos], str)
		} else {
			ret = append(ret, []string{str})
			posMap[strSorted] = len(ret) - 1
		}
	}

	return ret
}

func testGroupAnagrams() {
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}
