package main

import (
	"fmt"
)

func groupAnagrams(strs []string) [][]string {
	prime := []int{5, 71, 37, 29, 2, 53, 59, 19, 11, 83, 79, 31, 43, 13, 7, 67, 97, 23, 17, 3, 41, 73, 47, 89, 61, 101}
	tmp := make(map[int][]string, len(strs)/2)

	for _, s := range strs {
		c := 1
		for i := range s {
			c *= prime[s[i]-'a']
		}

		tmp[c] = append(tmp[c], s)
	}

	res := make([][]string, 0, len(tmp))
	for _, v := range tmp {
		res = append(res, v)
	}

	return res
}

func main() {
	res := groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"})
	//res := groupAnagrms([]string{"eat", "tea", "ate"})

	fmt.Println(res)
}
