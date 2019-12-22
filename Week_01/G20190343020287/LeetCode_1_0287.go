package leetcode

// 题目地址 https://leetcode-cn.com/problems/two-sum/
// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
// 示例: 给定 nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
// twoSum1 两次循环，逐一遍历
func twoSum1(nums []int, target int) []int {
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return []int{-1, -1}
}

// twoSum2 利用 map 也就是哈希表
func twoSum2(nums []int, target int) []int {
	numsMap := make(map[int]int, 0)
	for i := 0; i < len(nums); i++ {
		if _, ok := numsMap[target-nums[i]]; ok {
			return []int{numsMap[target-nums[i]], i}
		}
		numsMap[nums[i]] = i
	}
	return []int{-1, -1}
}

// @lc code=end
