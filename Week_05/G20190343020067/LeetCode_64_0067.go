package main

import (
	"fmt"
)

func minPathSum(grid [][]int) int {
	col := len(grid)
	line := len(grid[0])

	dp := make([]int, len(grid[0]))

	for i := col - 1; i >= 0; i-- {
		for j := line - 1; j >= 0; j-- {
			if i == col-1 && j != line-1 {
				dp[j] = grid[i][j] + dp[j+1]
			} else if j == line-1 && i != col-1 {
				dp[j] = grid[i][j] + dp[j]
			} else if j != line-1 && i != col-1 {
				dp[j] = grid[i][j] + min(dp[j], dp[j+1])
			} else {
				dp[j] = grid[i][j]
			}
		}
	}

	return dp[0]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	para := [][]int{
		{1, 3, 1},
		{1, 5, 1},
		//{4, 2, 1},
	}

	res := minPathSum(para)

	fmt.Println(res)
}
