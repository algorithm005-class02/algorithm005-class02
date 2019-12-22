package leetcode

import (
	"reflect"
	"sort"
)

// 题目地址 https://leetcode-cn.com/problems/3sum/submissions/
// 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
// 注意：答案中不可以包含重复的三元组。
// 示例:给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：[[-1, 0, 1],[-1, -1, 2]]

/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

// @lc code=start
// threeSum1 利用三层循环，去遍历每个数，
// 去重，还需要去遍历一次，当然去重可以用哈希表。减少一次循环。
// 时间复杂度 O(n^4),第 253 个 case 超时了，未 AC，代码本身没问题
func threeSum1(nums []int) [][]int {
	dArray := [][]int{}
	for i := 0; i < len(nums)-2; i++ {
		for j := i + 1; j < len(nums)-1; j++ {
			for k := j + 1; k < len(nums); k++ {
				if nums[i]+nums[j]+nums[k] == 0 {
					ret := []int{nums[i], nums[j], nums[k]}
					// 判断元素是否存在
					sort.Ints(ret)
					exist := false
					for _, arr := range dArray {
						if reflect.DeepEqual(arr, ret) {
							exist = true
						}
					}
					if !exist {
						dArray = append(dArray, ret)
					}
				}
			}
		}
	}
	return dArray
}

// threeSum 对数组排序，然后利用双指针夹逼
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	dArray := [][]int{}
	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		if nums[i] > 0 {
			break
		}
		j := i + 1
		k := len(nums) - 1
		for j < k {
			if nums[i]+nums[j]+nums[k] == 0 {
				dArray = append(dArray, []int{nums[i], nums[j], nums[k]})
				j++
				k--
				// 去重
				for j < k && nums[j] == nums[j-1] {
					j++
				}
				for j < k && nums[k] == nums[k+1] {
					k--
				}
			} else if nums[i]+nums[j]+nums[k] > 0 {
				k--
			} else {
				j++
			}
		}
	}
	return dArray
}

// @lc code=end
