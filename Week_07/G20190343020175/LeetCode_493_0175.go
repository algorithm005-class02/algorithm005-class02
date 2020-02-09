package main

import "fmt"

func reversePairs(nums []int) int {
	defer fmt.Println(nums)
	return mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, left, right int) int {
	if right <= left {
		return 0
	}
	fmt.Println(nums[left:right])
	mid := (left + right) >> 1
	ret := mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right)
	for i, j := left, mid+1; i <= mid; i++ {
		for j <= right && nums[i]/2 > nums[j] {
			j++
		}
		ret += j - (mid + 1)
	}
	merge(nums, left, mid, right)

	return ret
}

func merge(nums []int, left, mid, right int) {
	temp := make([]int, right-left+1)
	i, j, k := left, mid+1, 0

	for ; i <= mid && j <= right; k++ {
		if nums[i] < nums[j] {
			temp[k], i = nums[i], i+1
		} else {
			temp[k], j = nums[j], j+1
		}
	}

	for i <= mid {
		temp[k], k, i = nums[i], k+1, i+1
	}
	for j <= right {
		temp[k], k, j = nums[j], k+1, j+1
	}

	for p := 0; p < len(temp); p++ {
		nums[left+p] = temp[p]
	}
}
