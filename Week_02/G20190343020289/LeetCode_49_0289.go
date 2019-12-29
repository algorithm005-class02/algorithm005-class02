package G20190343020289

import (
	"sort"
	"strings"
)

//49. 字母异位词分组
func groupAnagrams(strs []string) [][]string {
	// 可以联想hash表
	// hashingFunc计算出下标，同一下标(发生hash碰撞)归为一类
	maps := make(map[string][]string)
	for _, v := range strs {
		hashIndex := hashingFunc(v)
		maps[hashIndex] = append(maps[hashIndex], v)
	}
	res := make([][]string, 0, len(maps))
	for _, v := range maps {
		res = append(res, v)
	}
	return res
}

func hashingFunc(w string) string {
	s := strings.Split(w, "")
	sort.Strings(s)
	return strings.Join(s, "")
}
