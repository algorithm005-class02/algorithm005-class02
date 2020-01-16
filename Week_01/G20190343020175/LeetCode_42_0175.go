package main

import (
	"fmt"
)

func trapBruteForce(height []int) int {
	left, right := 0, len(height)-1
	leftMax, rightMax := 0, 0
	ans := 0

	for left < right {
		if height[left] < height[right] {
			if height[left] >= leftMax {
				leftMax = height[left]
			} else {
				ans += leftMax - height[left]
			}
			left++
		} else {
			if height[right] >= rightMax {
				rightMax = height[right]
			} else {
				ans += rightMax - height[right]
			}
			right--
		}
	}
	return ans
}

func main() {
	fmt.Println(trapBruteForce([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}
