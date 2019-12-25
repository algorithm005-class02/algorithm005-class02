package leetcode

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=47 lang=golang
 *
 * [47] 全排列 II
 */

// @lc code=start
func permuteUnique(nums []int) [][]int {
	if nums == nil {
		return nil
	}
	sort.Ints(nums)
	return permuteCal(nums, 0, [][]int{})
}

func permuteCal(nums []int, depth int, result [][]int) [][]int {
	if len(nums) == depth {
		r := make([]int, len(nums))
		copy(r, nums)
		return append(result, r)
	}
	// 缓存已排列过的数字 重复数字不再做排列
	cacheMap := map[int]bool{}

	for i := depth; i < len(nums); i++ {
		num := nums[i]
		if !cacheMap[num] {
			cacheMap[num] = true
			// 不断交换形成新排列
			nums[depth], nums[i] = nums[i], nums[depth]
			result = permuteCal(nums, depth+1, result)
			// 换回
			nums[depth], nums[i] = nums[i], nums[depth]
		}
	}
	return result
}

// @lc code=end
