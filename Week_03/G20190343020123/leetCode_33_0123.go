package main

import "fmt"

//33. 搜索旋转排序数组
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[left] == target {
			return left
		} else if nums[right] == target {
			return right
		} else if nums[mid] == target {
			return mid
		} else {
			if target > nums[mid] {
				if nums[mid] > nums[0] {
					left = mid + 1
				} else {
					if target > nums[0] {
						right = mid - 1
					} else {
						left = mid + 1
					}
				}
			} else {
				if nums[mid] < nums[0] {
					right = mid - 1
				} else {
					if target < nums[0] {
						left = mid + 1
					} else {
						right = mid - 1
					}
				}
			}
		}
	}
	return -1
}

func main() {
	nums := []int{4, 5, 6, 7, 0, 1, 2}
	res := search(nums, 0)
	fmt.Printf("%d\n", res)
}
