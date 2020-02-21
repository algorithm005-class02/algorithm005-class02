package G20190343020259

func rotate(nums []int, k int) {
	count := len(nums)
	if count < 1 {
		return
	}

	k = k % count

	reverse(nums, 0, count - 1)
	reverse(nums, 0, k - 1)
	reverse(nums, k, count - 1)
}

func reverse(nums[]int, left, right int) {
	for left < right {
		nums[left], nums[right] = nums[right], nums[left]
		left++
		right--
	}
}
