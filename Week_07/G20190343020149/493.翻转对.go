package leetcode

/*
 * @lc app=leetcode.cn id=493 lang=golang
 *
 * [493] 翻转对
 */

// @lc code=start
func reversePairs(nums []int) int {
	return mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, left, right int) int {
	if left >= right {
		return 0
	}
	mid := left + ((right - left) / 2)
	count := mergeSort(nums, left, mid) +
		mergeSort(nums, mid+1, right)
	cache := make([]int, right-left+1)
	l := left
	t := left
	c := 0
	i := mid + 1
	for i <= right {
		for l <= mid && nums[l] <= 2*nums[i] {
			l++
		}
		for t <= mid && nums[t] < nums[i] {
			cache[c] = nums[t]
			c++
			t++
		}
		cache[c] = nums[i]
		count += (mid - l + 1)
		i++
		c++
	}
	for t <= mid {
		cache[c] = nums[t]
		c++
		t++
	}
	for j, val := range cache {
		nums[left+j] = val
	}
	return count
}

// @lc code=end
