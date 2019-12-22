package main

import "fmt"

//70. 爬楼梯
//https://leetcode-cn.com/problems/climbing-stairs/
func clibStairs(n int) int {
	return climb1(0, n)
}

//暴力法
func climb1(i, n int) int {
	if i == n {
		return 1
	}
	if i > n {
		return 0
	}
	return climb1(i+1, n) + climb1(i+2, n)
}
func main() {
	res := clibStairs(3)
	fmt.Printf("res:%d\n", res)
}
