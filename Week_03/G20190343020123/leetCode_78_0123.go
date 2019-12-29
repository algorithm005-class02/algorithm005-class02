package main

import "fmt"

//子集
//https://leetcode-cn.com/problems/subsets/
//思路1：考虑层遍历求解,每次就扩充res返回来的长度，直到所有的元素都添加完毕
//步骤 []
//    [] [1]
//    [] [1] [2] [1,2]
//    [] [1] [2] [1,2] [3] [1,3] [2,3] [1,2,3]
func subsets1(nums []int) [][]int {
	res := make([][]int, 1) //[]
	for _, num := range nums {
		for _, sub := range res {
			clone := make([]int, len(sub), len(sub)+1)
			copy(clone, sub)
			clone = append(clone, num)
			res = append(res, clone)
		}
	}
	return res
}

func subsets(nums []int) [][]int {
	res := make([][]int, 0)
	dfs(&res, nums, nil, 0)
	return res
}

func dfs(res *[][]int, nums []int, list []int, index int) {
	//teminiator
	if index == len(nums) {
		*res = append(*res, list)
		return
	}
	//not pick the number at this index
	dfs(res, nums, list, index+1)
	list = append(list, nums[index])

	dfs(res, nums, list, index+1)
}

func main() {
	nums := []int{1, 2, 3}
	res := subsets(nums)
	fmt.Printf("%v\n", res)
}
