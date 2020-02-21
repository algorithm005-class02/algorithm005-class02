package main

import "fmt"

//pow(x,n) 计算x^n次方
//https://leetcode-cn.com/problems/powx-n/
//思路：采用分治，将问题递归在合并
//eg: x^n --> 2^10 : 2^5 ->(2^2)*2
//    pow(x,n)
//		subproblem: subresult = pow(x,n/2)
//   merge:
//	if n %2 == 1
//  	result = subresult * subresult * x
//  else
//     result = subresult * subreslut
//时间复杂度:O(log(N))

func myPow(x float64, n int) float64 {
	if x < 0 {
		x = 1 / x
		n = -n
	}
	return fastPow(x, n)
}
func fastPow(x float64, n int) float64 {
	//recursion terminator
	if n == 0 {
		return 1
	}
	//process logic
	//conquer subproblem
	half := fastPow(x, n/2)
	//process and generator the final result
	if n%2 == 0 {
		return half * half
	} else {
		return half * half * x

	}
}
func main() {
	res := myPow(2, 1024)
	fmt.Printf("%f\n", res)
}
