package G20190343020259

func search(nums []int, target int) int {
	left, right := 0, len(nums) - 1

	for left < right {
		mid := (right + left) / 2
		if nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]) {
			left = mid + 1
		} else if target > nums[mid] && (target < nums[0]) {
			left = mid + 1
		} else {
			right = mid
		}
	}

	if left == right && nums[left] == target {
		return left
	}

	return -1
}
