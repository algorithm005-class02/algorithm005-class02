package main

import "fmt"

func main() {
	test1 := []int{2, 7, 9, 3, 1}
	test2 := []int{1, 2, 3, 1}
	test3 := []int{1, 2}
	test4 := []int{2, 1, 1, 2}
	fmt.Println(rob(test1))
	fmt.Println(rob(test2))
	fmt.Println(rob(test3))
	fmt.Println(rob(test4))
	fmt.Println()
	fmt.Println(rob2(test1))
	fmt.Println(rob2(test2))
	fmt.Println(rob2(test3))
	fmt.Println(rob2(test4))
	fmt.Println()
	fmt.Println(rob3(test1))
	fmt.Println(rob3(test2))
	fmt.Println(rob3(test3))
	fmt.Println(rob3(test4))
	fmt.Println("rob4")
	fmt.Println(rob4(test1))
	fmt.Println(rob4(test2))
	fmt.Println(rob4(test3))
	fmt.Println(rob4(test4))
	fmt.Println()
	fmt.Println(rob5(test1))
	fmt.Println(rob5(test2))
	fmt.Println(rob5(test3))
	fmt.Println(rob5(test4))
	fmt.Println()
	fmt.Println(rob6(test1))
	fmt.Println(rob6(test2))
	fmt.Println(rob6(test3))
	fmt.Println(rob6(test4))
}

// 1. DFS
func rob(nums []int) int {
	res := 0
	helper(nums, 0, 0, false, &res)
	return res
}

// 每个位置选还是不选
func helper(nums []int, level int, sum int, lastSelectFlag bool, res *int) {
	// terminator
	if level >= len(nums) {
		if sum > *res {
			*res = sum
		}
		return
	}
	// process
	if lastSelectFlag {
		// 上一个选了，当前这个不能选
		helper(nums, level+1, sum, false, res)
	} else {
		// 上一个没选
		helper(nums, level+1, sum+nums[level], true, res) // 选这个
		helper(nums, level+1, sum, false, res)            // 不选这个
	}
}

// DP
// 状态定义
// dp1[i]表示偷了第i家的最大利润
// dp2[i]表示没偷第i家的最大利润
// dp1[i] = max(dp1[i-2], dp2[i-1]) + nums[i]
// dp2[i] = max(dp1[i-1], dp2[i-1])
func rob2(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	length := len(nums)
	dp1, dp2 := make([]int, length), make([]int, length)
	dp1[0], dp2[0] = nums[0], 0
	dp1[1], dp2[1] = nums[1], dp1[0]

	for i := 2; i < length; i++ {
		dp1[i] = max(dp1[i-2], dp2[i-1]) + nums[i]
		dp2[i] = max(dp1[i-1], dp2[i-1])
	}

	return max(dp1[length-1], dp2[length-1])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// DP
// 状态定义
// dp[i][0]表示没偷第i家的最大利润, dp[i][1]表示偷了第i家的最大利润
// dp[i][0] = max(dp[i-1][0], dp[i-1][1])
// dp[i][1] = max(dp[i-2][1], dp[i-1][0]) + nums[i]
func rob3(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}

	length := len(nums)
	dp := make([][2]int, length)
	dp[0][1] = nums[0]
	dp[1][0], dp[1][1] = dp[0][1], nums[1]

	for i := 2; i < len(nums); i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1])
		dp[i][1] = max(dp[i-2][1], dp[i-1][0]) + nums[i]
	}
	return max(dp[length-1][0], dp[length-1][1])
}

// DP
// 只开一个数组
// 位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，
// 要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
// 借了一位，直接结算数组下标从1开始，把0下标用0，也解决了i-2越界问题！
func rob4(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}

	length := len(nums)
	dp := make([]int, length+1)
	dp[0], dp[1] = 0, nums[0]
	for i := 1; i < len(nums); i++ {
		dp[i+1] = max(dp[i], dp[i-1]+nums[i])
	}
	//fmt.Println(dp)
	return dp[length]
}

// 奇偶处理，直接用两个变量，空间复杂度O(1)
//https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-ikaruga/
func rob5(nums []int) int {
	sumOdd := 0
	sumEven := 0
	for i := 0; i < len(nums); i++ {
		if i&1 == 0 {
			sumEven += nums[i]
			sumEven = max(sumOdd, sumEven)
		} else {
			sumOdd += nums[i]
			sumOdd = max(sumOdd, sumEven)
		}
	}
	return max(sumOdd, sumEven)
}

// 官方题解给出的精简写法，不太好理解，代码可读性差
func rob6(nums []int) int {
	prevMax := 0
	currMax := 0
	temp := 0
	for _, x := range nums {
		temp = currMax
		currMax = max(prevMax+x, currMax)
		prevMax = temp
	}
	return currMax
}
