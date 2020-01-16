package leetcode

// 题目地址 https://leetcode-cn.com/problems/move-zeroes/
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
// 示例: 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
// 说明: 1.必须在原数组上操作，不能拷贝额外的数组。2.尽量减少操作次数。

/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 */

// @lc code=start

// moveZeroes1
// 用两层循环
// 第一层循环将非零数放到数组前面
// 第二层循环将后面补零
func moveZeroes1(nums []int) {
	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[j] = nums[i]
			j++
		}
	}
	for ; j < len(nums); j++ {
		nums[j] = 0
	}
}

// moveZeroes2
//利用双指针，遇到零就和后面的非零数进行交换
func moveZeroes2(nums []int) {
	i, j := 0, 0
	for j < len(nums) {
		nums[i], nums[j] = nums[j], nums[i]
		if nums[i] != 0 {
			i++
		}
		j++
	}
}

// moveZeroes3
// 利用双指针，遇到零就和后面非零数进行交换，
func moveZeroes3(nums []int) {
	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			continue
		}
		nums[j] = nums[i]
		if i != j {
			nums[i] = 0
		}
		j++
	}
}

// @lc code=end
