package leetcode

/*
 * @lc app=leetcode.cn id=127 lang=golang
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (38.50%)
 * Likes:    181
 * Dislikes: 0
 * Total Accepted:    17.6K
 * Total Submissions: 45.6K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 *
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 *
 * 说明:
 *
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 *
 *
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 */

// @lc code=start
// ladderLength1 会超时
func ladderLength1(beginWord string, endWord string, wordList []string) int {
	m := make(map[string]bool)
	for _, v := range wordList {
		m[v] = true
	}

	if _, ok := m[endWord]; !ok {
		return 0
	}

	list := []string{}
	list = append(list, beginWord)
	ret := 1
	for len(list) > 0 {
		l := len(list)
		for i := 0; i < l; i++ {
			word := list[0]
			list = list[1:]
			if word == endWord {
				return ret
			}
			m[word] = false
			for j, _ := range word {
				for k := 0; k < 26; k++ {
					tmp := []rune(word)
					tmp[j] = rune('a' + k)
					if v, ok := m[string(tmp)]; ok && v && ((len(list) != 0 && string(tmp) != list[len(list)-1]) || len(list) == 0) {
						list = append(list, string(tmp))
					}
				}
			}
		}
		ret++
	}
	return 0
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	m := make(map[string]bool)
	for _, v := range wordList {
		m[v] = true
	}
	if _, ok := m[endWord]; !ok {
		return 0
	}
	list := []string{}
	list = append(list, beginWord)
	ret := 1
	for len(list) > 0 {
		l := len(list)
		for i := 0; i < l; i++ {
			word := list[0]
			list = list[1:]
			if string(word) == endWord {
				return ret
			}
			for j := 0; j < len(word); j++ {
				tmp := []rune(word)
				for k := 0; k < 26; k++ {
					if rune('a'+k) == tmp[j] {
						continue
					}
					tmp[j] = rune('a' + k)
					if _, ok := m[string(tmp)]; !ok {
						continue
					}
					delete(m, string(tmp))
					list = append(list, string(tmp))
				}
			}
		}
		ret++
	}
	return 0
}

// @lc code=end
