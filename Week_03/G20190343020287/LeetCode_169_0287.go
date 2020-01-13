package leetcode

/*
 * @lc app=leetcode.cn id=169 lang=golang
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (60.84%)
 * Likes:    395
 * Dislikes: 0
 * Total Accepted:    94.8K
 * Total Submissions: 155.6K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 *
 */

// @lc code=start
// majorityElement 利用 map 计数
func majorityElement(nums []int) int {
	m := make(map[int]int, 0)
	ret := 0
	for _, n := range nums {
		m[n]++
		if m[n] > len(nums)/2 {
			ret = n
		}
	}
	return ret
}

// @lc code=end
