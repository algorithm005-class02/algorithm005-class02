/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	l := len(nums)
    for i := 0; i < l - 1; i++ {
		for j := i + 1; j < l; j++ {
			if nums[i] + nums[j] == target {
				return []int{i,j}
			}
		}
	}
	return []int{-1, -1}
}
// @lc code=end