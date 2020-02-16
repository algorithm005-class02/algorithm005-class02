func lengthOfLIS(nums []int) int {
    l := len(nums)
    if l < 2 {
        return l
    }
    dp := make([]int, l)
    dp[0] = 1
    res := 1
    for i := 1; i < l; i++ {
        maxVal := 0
        for j := 0; j < i; j++ {
            if nums[i] > nums[j] {
                maxVal = max(maxVal, dp[j])
            }
        }
        dp[i] = maxVal + 1
        res = max(res, dp[i])
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}