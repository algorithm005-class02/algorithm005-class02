package main

import (
	"fmt"
)

// 解法一：暴力法、
// 从末尾移动k个元素，对末尾元素与从下表为0起的其他元素挨个交换位置

// 时间复杂度：O(n*k)
// 空间复杂度：O(1)
func rotate(nums []int, k int) {
	for i := 0; i < k; i++ {

		target := nums[len(nums)-1 ]

		for j := 0; j < len(nums); j++ {
			nums[j], target = target, nums[j]
		}
	}

	fmt.Println(nums)
}

// 解法二:数组反转
// 将整个数组反转；对前K个元素反转；对剩下元素反转
// k>len(nums)的情况会出现数组取值超出范围，必须处理

// 时间复杂度：O(n)
// 空间复杂度：O(1)
func rotateTwo(nums []int, k int) {
	n := len(nums)

	if k > n {
		k = k % n
	}

	if k == 0 || k == n {
		return
	}

	reverse(nums, 0, len(nums)-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, len(nums)-1)

	fmt.Println(nums)
}

func reverse(nums []int, i, j int) {
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}

func main() {
	//rotate([]int{1, 2, 3, 4, 5, 6, 7}, 3)
	rotateTwo([]int{1, 2, 3, 4, 5, 6, 7}, 9)
}
