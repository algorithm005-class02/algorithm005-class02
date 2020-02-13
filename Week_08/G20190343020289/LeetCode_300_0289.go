package G20190343020289

//300. 最长上升子序列
func lengthOfLIS(nums []int) int {
	// dp + 二分查找
	// dp[i] 代表长度为i+1的子序列尾部元素的值

	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	length := 0
	for i := 0; i < len(dp); i++ {
		// 在长度length的数组d中，找到nums[i]的插入位置i
		j := binarySearchInsertPosition(dp, length, nums[i])
		dp[j] = nums[i]
		if j == length {
			length++
		}
	}
	return length
}

func binarySearchInsertPosition(dp []int, len int, target int) int {
	l, r := 0, len-1
	for l <= r {
		mid := (r + l) / 2
		if dp[mid] == target {
			return mid
		} else if dp[mid] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return l
}
