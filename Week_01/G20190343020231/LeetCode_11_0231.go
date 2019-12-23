package main

import "fmt"

func main() {
	test := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	fmt.Println(maxArea(test))
	fmt.Println(maxArea2(test))
}

// 第一种解法：暴力，时间复杂度O（N）
func maxArea(height []int) int {
	res, rectArea := 0, 0
	for i := 0; i < len(height); i++ {
		for j := i + 1; j < len(height); j++ {
			rectArea = (j - i) * min(height[i], height[j])
			if rectArea > res {
				res = rectArea
			}
		}
	}
	return res
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

// 第二种解法：从两边向中间夹，由于面积受制于短线，因此向内移动长线势必面积更小，所以这里
// 的小技巧就是向内移动短线，记录每次的面积，并更新最大值，时间复杂度O（N^2）
func maxArea2(height []int) int {
	res, rectArea := 0, 0
	start, end := 0, len(height)-1
	for start != end {
		rectArea = (end - start) * min(height[start], height[end])
		if res < rectArea {
			res = rectArea
		}
		if height[start] > height[end] {
			end-- // 移动短线
		} else {
			start++
		}
	}
	return res
}
