package G20190343020289

func trap(height []int) int {
	//water := 0
	//size := len(height)
	//for i := 1; i < len(height)-1; i++ {
	//	maxLeft := 0
	//	maxRight := 0
	//	for j := i; j >= 0; j-- {
	//		maxLeft = max(maxLeft, height[j])
	//	}
	//	for j := i; j < size; j++ {
	//		maxRight = max(maxRight, height[j])
	//	}
	//	water += min(maxLeft, maxRight) - height[i]
	//}
	//return water

	//双指针
	left := 0
	right := len(height) - 1
	water := 0
	maxLeft := 0
	maxRight := 0
	for {
		if left >= right {
			break
		}
		if height[left] < height[right] {
			if height[left] >= maxLeft {
				maxLeft = height[left]
			} else {
				water += maxLeft - height[left]
			}
			left++
		} else {
			if height[right] >= maxRight {
				maxRight = height[right]
			} else {
				water += maxRight - height[right]
			}
			right--
		}
	}
	return water
}

//func max(a int, b int) int {
//	if a > b {
//		return a
//	}
//	return b
//}
//
//func min(a int, b int) int {
//	if a < b {
//		return a
//	}
//	return b
//}
