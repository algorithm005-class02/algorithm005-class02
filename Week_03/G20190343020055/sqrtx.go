package week03

import (
	"fmt"
)

func mySqrt(x int) int {

	if x == 0 || x == 1 {
		return x
	}

	left, right := 1, x

	for left <= right {

		mid := left + (right-left)/2
		fmt.Println("mid: ", mid)

		if mid*mid > x {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	if right*right > x {
		right = left
	}

	return right
}
