package leetcode

/*
 * @lc app=leetcode.cn id=312 lang=golang
 *
 * [312] 戳气球
 */

// @lc code=start
func maxCoins(nums []int) int {
	// 数组首位插入哨兵数据
	nums = append(nums, 1)
	nums = append([]int{1}, nums...)
	numsLen := len(nums)

	var dp [][]int = make([][]int, numsLen)
	for i := range nums {
		dp[i] = make([]int, numsLen)
	}

	for r := 2; r < numsLen; r++ { //区间由小扩大
		for i := 0; i < numsLen-r; i++ { //区间起始点
			j := i + r //区间终点
			for k := i + 1; k < j; k++ {
				tempVal := dp[i][k] + dp[k][j] + nums[i]*nums[j]*nums[k]
				if dp[i][j] < tempVal {
					dp[i][j] = tempVal
				}
			}
		}
	}
	// dp[i+1][j-1] 表示数组 i,j 区间的最大硬币数
	return dp[0][numsLen-1]
}

// 1. 子问题
// 分解为各个子区间解决
// 在区间为[i,j]内，不戳破i和j不断中间的气球，且最后一个戳破的位置为k
// 结果为区间[i,k]最大硬币数 + 区间[k,j]最大硬币数 + nums[i] * num[j] * nums[k]
// 2. 存储中间状态
// 存储区间[i,j]内获得的最大硬币数
// 3. 状态转移方程
// dp[i][j] = for ... { max(dp[i][j] , dp[i][k] + dp[k][j] + nums[i] * nums[j] * nums[k]) }
// @lc code=end
