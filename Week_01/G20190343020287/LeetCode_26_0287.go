package leetcode

// 题目地址 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
// 示例:给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 你不需要考虑数组中超出新长度后面的元素。
// 说明：为什么返回数值是整数，但输出的答案是数组呢?请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
// removeDuplicates1
// 利用 go slice 的特性
func removeDuplicates1(nums []int) int {
	for i := len(nums) - 1; i > 0; i-- {
		if nums[i] == nums[i-1] {
			nums = append(nums[:i], nums[i+1:]...)
		}
	}
	return len(nums)
}

// removeDuplicates2
// 利用双指针
func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	j := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[i-1] {
			nums[j] = nums[i]
			j++
		}
	}
	return j
}

// @lc code=end
