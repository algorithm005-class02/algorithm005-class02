package G20190343020259

func majorityElement(nums []int) int {
	return backtrack(nums, 0, len(nums)-1)
}

func backtrack(nums []int, start int, end int) int {
	if start == end {
		return nums[start]
	}

	mid := (end - start)/2 + start

	left := backtrack(nums, start, mid)
	right := backtrack(nums, mid+1, end)

	if left == right {
		return left
	}

	leftCount := count(nums, left, start, end)
	rightCount := count(nums, right, start, end)

	if leftCount > rightCount {
		return left
	} else {
		return right
	}
}

func count(nums []int, curr int, start int, end int) int {
	var count = 0
	for i := start; i <= end; i++ {
		if nums[i] == curr {
			count++
		}
	}
	return count
}
