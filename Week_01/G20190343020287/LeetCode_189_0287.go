package leetcode

// 题目地址 https://leetcode-cn.com/problems/rotate-array/
// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
// 示例:输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释:向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4]
// 说明：尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。要求使用空间复杂度为 O(1) 的 原地 算法。

/*
 * @lc app=leetcode.cn id=189 lang=golang
 *
 * [189] 旋转数组
 */

// @lc code=start
// rotate1 和示例一样，每次只移动最后的元素
func rotate1(nums []int, k int) {
	for i := 0; i < k; i++ {
		prev := nums[len(nums)-1]
		for j := 0; j < len(nums); j++ {
			nums[j], prev = prev, nums[j]
		}
	}
}

// rotate2 当 k>length 时，移动 k 次实际上移动了 k%length
// 使用环状替换，将每个元素放到对应的位置上，直到移到第一个移动的元素的位置，此时完成了第一个环
// 重复上诉步骤，直至完成所有的环
func rotate2(nums []int, k int) {
	count := 0
	k = k % len(nums)
	for i := 0; count < len(nums); i++ {
		j := i
		tmp := nums[j]
		for {
			j = (k + j) % len(nums)
			nums[j], tmp = tmp, nums[j]
			count++
			if i == j {
				break
			}
		}
	}
}

// rotate3 是 rotate2 的变形态，也是利用环状替换
// 利用最大公约数，最大公约数是几就是几个环
func rotate3(nums []int, k int) {
	gcd := func(a, b int) int {
		for {
			if b == 0 {
				return a
			}
			a, b = b, a%b
		}
	}

	k = k % len(nums)
	cycles := gcd(k, len(nums))
	for i := 0; i < cycles; i++ {
		j := i
		tmp := nums[j]
		for l := 0; l < len(nums)/cycles; l++ {
			j = (j + k) % len(nums)
			nums[j], tmp = tmp, nums[j]
		}
	}

}

// rotate4 利用三次反转数组
// 1.将整个数组反转
// 2.将 k 之前的反转
// 3.将 k 之后的反转
func rotate4(nums []int, k int) {
	reverse := func(nums []int) {
		for i, j := 0, len(nums)-1; i < j; {
			nums[i], nums[j] = nums[j], nums[i]
			i++
			j--
		}
	}

	k = k % len(nums)
	reverse(nums)
	reverse(nums[:k])
	reverse(nums[k:])
}

// rotate5 不符合题目要求，空间复杂度为O(n),拷贝了数组
func rotate(nums []int, k int) {
	arr := append(nums[len(nums)-k%len(nums):], nums[:len(nums)-k%len(nums)]...)
	nums = append(nums[:0], arr...)
}

// @lc code=end
