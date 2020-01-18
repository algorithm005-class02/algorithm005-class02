//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表
package main

//leetcode submit region begin(Prohibit modification and deletion)
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	// 辣鸡golang，毁我青春，字符串排序那么蛋疼，算了
	countMap := make(map[byte]int)	// 考虑到Unicode字符，就不用int26数组来刷时间复杂度了
	for i:= 0; i < len(s); i ++ {
		countMap[s[i]] += 1
	}
	for i:= 0; i < len(t); i ++  {
		if _, ok := countMap[t[i]]; !ok {
			return false
		}
		countMap[t[i]] -= 1
	}
	for _, cnt := range countMap {
		if cnt != 0 {
			return false
		}
	}
	return true
}
//leetcode submit region end(Prohibit modification and deletion)
