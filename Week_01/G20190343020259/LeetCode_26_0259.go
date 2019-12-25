package G20190343020259

func removeDuplicates(nums []int) int {
	count := len(nums)
	if count == 0 {
		return 0
	}

	var i = 0
	for j := 1; j < count; j++ {
		if nums[i] != nums[j] {
			i++
			nums[i] = nums[j]
		}
	}

	return i + 1
}
