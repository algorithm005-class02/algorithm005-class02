package G20190343020289

//33. 搜索旋转排序数组
func search(nums []int, target int) int {
	// 二分查找
	// 与普通的二分查找题目相比，这里需要多判断一个旋转
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}
		if nums[left] <= nums[mid] {
			// 左边升序
			if target >= nums[left] && target <= nums[mid] {
				// 在左边范围
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			//右边升序
			if target >= nums[mid] && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}
	return -1
}
