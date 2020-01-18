package G20190343020171

/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (47.07%)
 * Likes:    7154
 * Dislikes: 0
 * Total Accepted:    725.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	// 暴力法, 时间复杂度O(n2), cost 52ms
	// for i := 0; i < len(nums); i++ {
	// 	for j := 0; j < len(nums); j++ {
	// 		if (nums[i]+nums[j]) == target && i != j {
	// 			return []int{i, j}
	// 		}
	// 	}
	// }

	// hash code, 时间复杂度 O(n),cost time 4ms
	// table := make(map[int]int)
	// for idx := range nums {
	// 	table[target-nums[idx]] = idx
	// }
	// for idx := range nums {
	// 	if val, ok := table[nums[idx]]; ok {
	// 		if idx != val {
	// 			return []int{idx, val}
	// 		}
	// 	}
	// }

	// 一遍hash, cost 4ms, bad memory
	table := make(map[int]int)
	table[target-nums[0]] = 0
	for idx := range nums {
		if val, ok := table[nums[idx]]; ok {
			if val != idx {
				return []int{val,idx}
			}
		}
		table[target-nums[idx]] = idx
	}
	return nil
}

// @lc code=end
