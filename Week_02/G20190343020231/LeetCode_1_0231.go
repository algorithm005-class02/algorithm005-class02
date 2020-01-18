package main

import "fmt"

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}

// 1. 暴力
// 2. 使用hash表
func twoSum(nums []int, target int) []int {
	res := []int{}
	if len(nums) < 1 {
		return res
	}
	mapRes := make(map[int]int, 0)
	for idx, val := range nums {
		if _, ok := mapRes[val]; ok {
			res = append(res, mapRes[val], idx)
			break
		}
		mapRes[target-val] = idx
	}
	return res
}
