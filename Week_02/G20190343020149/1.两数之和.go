package leetcode

/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	numCache := map[int]int{}
	for i, num := range nums {
		if val, ok := numCache[target-num]; ok {
			return []int{val, i}
		}
		numCache[num] = i
	}
	return []int{}
}

// @lc code=end
