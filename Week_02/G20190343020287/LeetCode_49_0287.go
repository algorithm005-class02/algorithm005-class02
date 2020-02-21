package leetcode

// 题目地址 https://leetcode-cn.com/problems/group-anagrams
// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
// 示例:输入: ["eat", "tea", "tan", "ate", "nat", "bat"], 输出:[["ate","eat","tea"],["nat","tan"],["bat"]]

import "sort"

/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 */

// @lc code=start
// groupAnagrams 利用将两个字符串排序，来判断两个字符串是不是异位词
// 将排序过的字符串当做是 key ，利用 map 来存储， 循环 map 中的值，得到结果
func groupAnagrams(strs []string) [][]string {
	m := make(map[string][]string, 0)
	for _, s := range strs {
		b := []byte(s)
		sort.Slice(b, func(i, j int) bool {
			return b[i] < b[j]
		})
		m[string(b)] = append(m[string(b)], s)
	}

	ret := make([][]string, 0)
	for _, v := range m {
		ret = append(ret, v)
	}
	return ret
}

// @lc code=end
