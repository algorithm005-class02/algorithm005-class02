package main

import "fmt"

//1. 两数之和
//https://leetcode-cn.com/problems/two-sum/
//思路：把数组中的每个元素一一放到map中。循环数组，目标target 减去数组中的对应的值，判断返回的值在map中是否存在，
//存在则返回数组的下标。
//时间复杂度：
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		m[v] = i
	}
	for i := 0; i < len(nums); i++ {
		complement := target - nums[i]
		k, ok := m[complement]
		if ok {
			return []int{i, k}
		}
	}
	return nil
}
func main() {
	num := []int{2, 7, 11, 15}
	res := twoSum(num, 9)
	fmt.Printf("res:%v\n", res)
}
