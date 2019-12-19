package main

import "fmt"

func main()  {
	fmt.Println(climbStairs(10))
}

// 本质就是斐波那契数列问题
// 1. 直接递归，时间复杂度O(2^N)
// 2. 递归加记忆化，时间复杂度O(N)，空间复杂度O(N)
// 3. 迭代法，时间复杂度O(N)
// 4. 通项公式法，本质要求power(a, n)，时间复杂度O(lgN)
// 5. 矩阵相乘，时间复杂度为O(lgN)
// 6. 查表，时间复杂度为O(1)

// 解法3：迭代
func climbStairs(n int) int {
	if n <= 2 {
		return n
	}
	last, llast, res := 2, 1, 0
	for i := 3; i <= n; i++ {
		res = last + llast
		llast, last = last, res
	}
	return res
}