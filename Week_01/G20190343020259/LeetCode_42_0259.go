package G20190343020259

func trap(height []int) int {
	var total = 0

	count := len(height)
	left, right := 0, count - 1
	leftMax, rightMax := 0, 0

	for left < right {
		if height[left] < height[right] {
			if height[left] > leftMax {
				leftMax = height[left]
			} else {
				total += leftMax - height[left]
			}
			left++
		} else {
			if height[right] > rightMax {
				rightMax = height[right]
			} else {
				total += rightMax - height[right]
			}
			right--
		}
	}

	return total
}
