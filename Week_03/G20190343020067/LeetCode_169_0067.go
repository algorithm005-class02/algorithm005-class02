package main

func countInRange(nums []int, num, lo, hi int) int {
	count := 0
	for i := lo; i <= hi; i++ {
		if nums[i] == num {
			count++
		}
	}

	return count
}

func majorityElementConquer(nums []int, lo, hi int) int {
	//	recursion terminator
	if lo == hi {
		return nums[lo]
	}

	//	prepare data
	// 寻找中间值
	mid := (hi-lo)/2 + lo

	// conquer sub problems
	// 递归拆分
	left := majorityElementConquer(nums, lo, mid)
	right := majorityElementConquer(nums, mid+1, hi)

	if left == right {
		return left
	}

	// process and generate the final result
	// 统计拆分项中的众数
	leftCount := countInRange(nums, left, lo, hi)
	rightCount := countInRange(nums, right, lo, hi)

	// revert the current level states
	if leftCount > rightCount {
		return left
	} else {
		return right
	}
}

func majorityElement(nums []int) int {
	return majorityElementConquer(nums, 0, len(nums)-1)
}

func main() {
	majorityElement([]int{2, 2, 1, 1, 1, 2, 2})
}
