package G20190343020171

/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (59.51%)
 * Likes:    226
 * Dislikes: 0
 * Total Accepted:    40K
 * Total Submissions: 67.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 *
 * 说明：
 *
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 */

// @lc code=start
func groupAnagrams(strs []string) [][]string {
	outputs := [][]string{}
	// 字母计数方式, 时间复杂度O(nK), cost 92ms
	// tmp := make(map[string][]string)
	// for idx := range strs {
	// 	alphTable := make([]int, 26)
	// 	// 每个str计算字符数量
	// 	source := []byte(strs[idx])
	// 	for i := range source {
	// 		alphTable[source[i]-byte('a')]++
	// 	}
	// 	alph := strings.Trim(strings.Replace(fmt.Sprint(alphTable), " ", "", -1), "[]")
	// 	tmp[alph] = append(tmp[alph], strs[idx])
	// }
	// for _, value := range tmp {
	// 	outputs = append(outputs, value)
	// }
	// 质数唯一性方式, 确定唯一键, cost 24ms
	prime := []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}
	tmp := make(map[int][]string)
	for idx := range strs {
		// 每个str计算字符的质数
		source := []byte(strs[idx])
		result := 1
		for i := range source {
			result = result * prime[source[i]-byte('a')]
		}
		tmp[result] = append(tmp[result], strs[idx])
	}
	for _, value := range tmp {
		outputs = append(outputs, value)
	}
	return outputs
}

// @lc code=end
