package G20190343020289

//300. 最长上升子序列
func lengthOfLIS(nums []int) int {
	// dp
	// dp[i] 代表nums前i个数字的最长子序列长度
	// 推导状态转移方程
	// 1. nums[i]>nums[j] nums[i]可以接在nums[j]之后，dp[i]=dp[j]+1
	// 2. nums[i]<=nums[j] nums[i]不可以接在nums[j]之后，跳过
	// dp[i]=max(dp[i],dp[j]+1) for j in [0,i]
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	ans := 1
	for i := 0; i < len(dp); i++ {
		dp[i] = 1 //初始状态为1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		ans = max(ans, dp[i]) //返回值，最大上升子序列的长度
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
