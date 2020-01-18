package main

import (
	"fmt"
	"sort"
)

func main() {
	test1 := []int{1, 2, 5}
	test2 := []int{1, 9, 10}
	test3 := []int{2}
	test4 := []int{1, 3, 4, 5, 7, 10}
	test5 := []int{1, 8, 4, 2, 10, 7}
	fmt.Println(coinChange(test1, 11))
	fmt.Println(coinChange(test2, 18))
	fmt.Println(coinChange(test3, 3))
	fmt.Println(coinChange(test4, 19))
	fmt.Println(coinChange(test5, 19))
	fmt.Println()
	fmt.Println(coinChange2(test1, 11))
	fmt.Println(coinChange2(test2, 18))
	fmt.Println(coinChange2(test3, 3))
	fmt.Println(coinChange2(test4, 19))
	fmt.Println(coinChange2(test5, 19))
	fmt.Println()
	fmt.Println(coinChange3(test1, 11))
	fmt.Println(coinChange3(test2, 18))
	fmt.Println(coinChange3(test3, 3))
	fmt.Println(coinChange3(test4, 19))
	fmt.Println(coinChange3(test5, 19))
	fmt.Println()
	fmt.Println(coinChange4(test1, 11))
	fmt.Println(coinChange4(test2, 18))
	fmt.Println(coinChange4(test3, 3))
	fmt.Println(coinChange4(test4, 19))
	fmt.Println(coinChange4(test5, 19))
}

// 1. DP
// 抽象成走楼梯问题，每次只能走1步，9步，10步，走到18级台阶，需要的最小步数
// 走到第i级需走的步数(达到面值i所需要硬币个数)dp[i] = min(dp[i-coins[j]]) + 1
// 时间复杂度O(N*amount), 空间复杂度O （amout）
func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	dp[0] = 0
	temp := 0
	for i := 1; i <= amount; i++ {
		temp = amount + 1
		for j := 0; j < len(coins); j++ {
			// 遍历面值
			if i-coins[j] >= 0 && dp[i-coins[j]] >= 0 && temp > dp[i-coins[j]] {
				temp = dp[i-coins[j]]
			}
		}
		if temp == amount+1 {
			dp[i] = -1
		} else {
			dp[i] = temp + 1
		}
	}
	//fmt.Println(dp)
	return dp[amount]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

// 2. 暴力递归
// 子问题个数乘以解决一个子问题需要的时间。
// fn = 1 + min{dp[i-c[i]], i>=0 && i < len(c)}}
func coinChange2(coins []int, amount int) int {
	// terminator
	if amount <= 0 {
		return amount
	}

	res := amount + 1
	// process
	// drill down
	for i := 0; i < len(coins); i++ {
		temp := coinChange2(coins, amount-coins[i])
		if temp >= 0 && res > temp+1 {
			res = temp + 1
		}
	}

	if res == amount+1 {
		return -1
	}

	return res
}

// 3. BFS
func coinChange3(coins []int, amount int) int {
	queue := []int{amount}
	step := 0
	visited := make(map[int]struct{})
	for len(queue) != 0 {
		n := len(queue)
		for i := 0; i < n; i++ {
			temp := queue[0]
			queue = queue[1:]
			if temp == 0 {
				return step
			}
			for _, coin := range coins {
				// 如果temp>coin并且没有访问过
				if _, ok := visited[temp-coin]; temp >= coin && !ok {
					visited[temp-coin] = struct{}{}
					queue = append(queue, temp-coin)
				}
			}
		}
		// 每一层step+1
		step++
	}
	return -1
}

// 4. DFS
func coinChange4(coins []int, amount int) int {
	sum := 0
	min := amount + 1
	sort.Ints(coins) // 升序排列
	//fmt.Println(coins)
	helper(coins, amount, sum, len(coins)-1, &min)
	if min == amount+1 {
		return -1
	}
	return min
}

func helper(coins []int, amount int, sum int, index int, min *int) {
	// terminator
	// 用最大的面值获取最多个数进行尝试，如果还比min大，直接返回
	if index < 0 || (sum+amount/coins[index]) >= *min {
		return
	}
	if amount == 0 {
		if *min > sum {
			*min = sum
		}
		return
	}
	// process
	// drill down
	for i := index; i >= 0; i-- {
		if amount < coins[i] {
			continue
		}
		helper(coins, amount-coins[i], sum+1, i, min)
	}
}
