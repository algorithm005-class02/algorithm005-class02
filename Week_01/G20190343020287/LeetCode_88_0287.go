package leetcode

import (
	"sort"
)

// 题目地址 https://leetcode-cn.com/problems/merge-sorted-array
// 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
// 示例:输入:nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6],n = 3 输出: [1,2,2,3,5,6]
// 说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n。你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

/*
 * @lc app=leetcode.cn id=88 lang=golang
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
// merge1 合并数组，排序
func merge1(nums1 []int, m int, nums2 []int, n int) {
	nums1 = append(nums1[:m], nums2[:n]...)
	sort.Ints(nums1)
}

// merge2 利用双指针，从后向前循环。
// 使用两次循环，第一次循环将 num1 的数据全部循环完，放到指定位置
// 第二次循环，将没有循环完的 num2 的数据未放到指定位置的，放到指定位置
func merge2(nums1 []int, m int, nums2 []int, n int) {
	i, j, k := m-1, n-1, m+n-1
	for i >= 0 && j >= 0 {
		if nums1[i] < nums2[j] {
			nums1[k] = nums2[j]
			j--
		} else {
			nums1[k] = nums1[i]
			i--
		}
		k--
	}
	for ; j >= 0; j-- {
		nums1[j] = nums2[j]
	}
}

// merge3 利用双指针，从后向前循环。
// 对 merge2 进行了优化，只使用一次循环
// 利用什么时候应该把 nums1 的数据全部放进去，剩下的情况放入 nums2 的数据
func merge3(nums1 []int, m int, nums2 []int, n int) {
	i, j, k := m-1, n-1, m+n-1
	for k >= 0 {
		if j < 0 || (i >= 0 && nums1[i] > nums2[j]) {
			nums1[k] = nums1[i]
			i--
		} else {
			nums1[k] = nums2[j]
			j--
		}
		k--
	}
}

// @lc code=end
