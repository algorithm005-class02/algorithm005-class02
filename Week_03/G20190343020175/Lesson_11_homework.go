package main

func searchBegin(nums []int) int {
	if nil == nums || 0 == len(nums) {
		return -1
	}

	lo, hi := 0, len(nums)-1
	asc := nums[lo] > nums[hi]

	for lo < hi {
		mid := (lo + hi) / 2
		if asc && nums[mid] < nums[mid-1] || !asc && nums[mid] > nums[mid-1] {
			return mid
		}

		if asc {
			if nums[mid] < nums[0] {
				hi = mid - 1
			} else {
				lo = mid + 1
			}
		} else {
			if nums[mid] < nums[len(nums)-1] {
				lo = mid + 1
			} else {
				hi = mid - 1
			}
		}
	}

	if asc && nums[lo] < nums[lo-1] || !asc && nums[lo] > nums[lo-1] {
		return lo
	}
	return -1
}
