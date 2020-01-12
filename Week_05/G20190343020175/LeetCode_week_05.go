package main

import "fmt"

func minInt(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func maxInt(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func main() {
	//fmt.Println(longestValidParentheses(")()())"))
	//fmt.Println(minPathSum([][]int{[]int{1, 3, 1}, []int{1, 5, 1}, []int{4, 2, 1}}))
	fmt.Println(minDistance("intention", "execution"))
}
